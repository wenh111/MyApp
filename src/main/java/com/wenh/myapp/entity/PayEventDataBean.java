package com.wenh.myapp.entity;

import java.util.List;

public class PayEventDataBean {
    int count;
    List<AllPay> allPayList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<AllPay> getAllPayList() {
        return allPayList;
    }

    public void setAllPayList(List<AllPay> allPayList) {
        this.allPayList = allPayList;
    }
}
