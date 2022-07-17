package com.wenh.myapp.entity;

import java.util.List;

public class PayOrIncomeEventDataBean {
    int PayCount;
    int IncomeCount;
    List<AllPay> allPayList;
    List<AllPay> allIncomeList;



    public PayOrIncomeEventDataBean(int payCount, int incomeCount, List<AllPay> allPayList, List<AllPay> allIncomeList) {
        PayCount = payCount;
        IncomeCount = incomeCount;
        this.allPayList = allPayList;
        this.allIncomeList = allIncomeList;
    }

    public int getIncomeCount() {
        return IncomeCount;
    }

    public void setIncomeCount(int incomeCount) {
        IncomeCount = incomeCount;
    }
    public List<AllPay> getAllIncomeList() {
        return allIncomeList;
    }

    public void setAllIncomeList(List<AllPay> allIncomeList) {
        this.allIncomeList = allIncomeList;
    }

    public int getPayCount() {
        return PayCount;
    }

    public void setPayCount(int payCount) {
        this.PayCount = payCount;
    }

    public List<AllPay> getAllPayList() {
        return allPayList;
    }

    public void setAllPayList(List<AllPay> allPayList) {
        this.allPayList = allPayList;
    }
}
