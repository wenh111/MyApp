package com.wenh.myapp.entity;

import java.util.List;

public class MonthPayEventDataBean {

    List<AllPay> allPayList;
    int count;
    int since;
    int perPage;


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public List<AllPay> getAllPayList() {
        return allPayList;
    }

    public int getSince() {
        return since;
    }

    public void setSince(int since) {
        this.since = since;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public void setAllPayList(List<AllPay> allPayList) {
        this.allPayList = allPayList;
    }
}
