package com.wenh.myapp.entity;

import lombok.CustomLog;
import lombok.Data;

import java.util.List;

@Data

public class SaveMoneyEventListBean {
    int count;
    List<SaveMoneyEventBean> saveMoneyEvents;

    public SaveMoneyEventListBean(int count, List<SaveMoneyEventBean> saveMoneyEvents) {
        this.count = count;
        this.saveMoneyEvents = saveMoneyEvents;
    }
}
