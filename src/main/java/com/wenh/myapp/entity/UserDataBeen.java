package com.wenh.myapp.entity;

import java.util.List;

public class UserDataBeen {
    int count;
    List<User> userMessage;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<User> getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(List<User> userMessage) {
        this.userMessage = userMessage;
    }
}
