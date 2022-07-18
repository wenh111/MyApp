package com.wenh.myapp.entity;

import lombok.Data;

@Data
public class UploadSuccessfulMessage {
    String account;
    String type;
    String url;

    public UploadSuccessfulMessage(String account, String type, String url) {
        this.account = account;
        this.type = type;
        this.url = url;
    }
}
