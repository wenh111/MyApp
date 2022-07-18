package com.wenh.myapp.mapper;


import com.wenh.myapp.entity.UserPhotoBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserPhotoMapper {
    int insertPhoto(UserPhotoBean userPhotoBean);

    List<UserPhotoBean> selectPhoto(@Param("md5") String md5);

    List<UserPhotoBean> selectUserPhoto(@Param("account")String account);

    int updatePhoto(UserPhotoBean userPhotoBean);
}
