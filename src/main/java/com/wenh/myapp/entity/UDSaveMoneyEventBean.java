package com.wenh.myapp.entity;

import lombok.Data;

@Data
public class UDSaveMoneyEventBean {
    private double savedMoney;
    private String date;
    private int id;
    private int remainingTimes;
}
