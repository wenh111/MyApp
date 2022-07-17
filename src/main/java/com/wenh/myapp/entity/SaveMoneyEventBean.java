package com.wenh.myapp.entity;

import lombok.Data;

@Data
public class SaveMoneyEventBean {
    private double savedMoney;
    private double targetMoney;
    private String date;
    private String type;
    private String title;
    private String account;
    private String deadlineDate;
    private String customType ;
    private int amount;
    private int id;
    private int RemainingTimes;
}
