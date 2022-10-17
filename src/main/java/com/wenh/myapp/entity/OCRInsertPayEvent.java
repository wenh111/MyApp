package com.wenh.myapp.entity;

import lombok.Data;

@Data
public class OCRInsertPayEvent {
    private String account;
    private String payTime;
    private String location;
    private String category;
    private double cost;
    private String remark;
    private String date;
    private String time;
    private String year;
    private String month;
    private int int_date;
}
