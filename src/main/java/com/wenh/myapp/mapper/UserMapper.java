package com.wenh.myapp.mapper;

import com.wenh.myapp.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {


    List<User> allUser();

    User UserLoginMessage(@Param("account" )String account , @Param("password") String password);

    List<User> UserMessage(@Param("account" )String account ,@Param("telephone_number") String telephone_number);

    User UserForgetPasswordMessage(@Param("account" )String account ,@Param("telephone_number") String telephone_number);

    int UpdateUserPassword(@Param("account" )String account,@Param("password") String password);

    int insert(User user);
}
