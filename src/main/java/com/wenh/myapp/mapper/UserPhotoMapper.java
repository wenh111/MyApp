package com.wenh.myapp.mapper;


import com.wenh.myapp.entity.UserPhotoBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserPhotoMapper {
    int insertPhoto(UserPhotoBean userPhotoBean);

    List<UserPhotoBean> selectPhoto(String md5);
}
