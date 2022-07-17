package com.wenh.myapp.service;


import com.wenh.myapp.entity.UserDataBeen;
import com.wenh.myapp.entity.User;
import com.wenh.myapp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public UserDataBeen select(){
        UserDataBeen dataBeen = new UserDataBeen();
        List<User> users = userMapper.allUser();
        int count = users.size();
        dataBeen.setCount(count);
        dataBeen.setUserMessage(users);
        return dataBeen;
    }

    public UserDataBeen SelectSignUpMessage(String account, String telephone_number){
        UserDataBeen dataBeen = new UserDataBeen();
        List<User> users = userMapper.UserMessage(account,telephone_number);
        int count = users.size();
        dataBeen.setCount(count);
        dataBeen.setUserMessage(users);
        return dataBeen;
    }

    public User UserLogin(String account,String password){
        return userMapper.UserLoginMessage(account,password);
    }

    public User SelectUserForgetPassword(String account,String password){
        return userMapper.UserForgetPasswordMessage(account,password);
    }

    public int UpdateUserPassWord(String account,String password){
        return userMapper.UpdateUserPassword(account,password);
    }

    public int save(User user){
        return userMapper.insert(user);
    }

}
