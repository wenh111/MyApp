package com.wenh.myapp.controller;


import com.wenh.myapp.entity.User;
import com.wenh.myapp.entity.UserDataBeen;
import com.wenh.myapp.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping
    public UserDataBeen index() {
        return userService.select();
    }

    @GetMapping("/userLogin")
    public User Login(@RequestParam String account, @RequestParam String password) {
        return userService.UserLogin(account, password);
    }

    @GetMapping("/userSignUp")
    public UserDataBeen SignUpMessage(@RequestParam String account, @RequestParam String telephone_number) {
        return userService.SelectSignUpMessage(account, telephone_number);
    }

    @GetMapping("/userForgetPassword")
    public User ForgetWordMessage(@RequestParam String account, @RequestParam String telephone_number){
        return userService.SelectUserForgetPassword(account,telephone_number);
    }

    @PostMapping("/userForgetPassword/updatePassWord")
    public int UpdateUserPassword(@RequestParam String account, @RequestParam String password){
        return userService.UpdateUserPassWord(account, password);
    }

    @PostMapping("/userMessageInsert")
    public int SignUp(@RequestBody User user) {
        return userService.save(user);
    }


    @PostMapping("/userMessageUpdate")
    public int MessageUpdate(@RequestParam int id,@RequestParam String name) {
        return userService.update(id,name);
    }


}
