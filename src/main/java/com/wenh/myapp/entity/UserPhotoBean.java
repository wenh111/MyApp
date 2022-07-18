package com.wenh.myapp.entity;

import lombok.Data;

@Data
public class UserPhotoBean {
    private Integer id;
    private String name;
    private String type;
    private Long size;
    private String url;
    private String md5;
    private String account;
}
