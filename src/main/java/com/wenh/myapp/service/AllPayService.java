package com.wenh.myapp.service;

import com.wenh.myapp.entity.AllPay;
import com.wenh.myapp.entity.PayEventDataBean;
import com.wenh.myapp.entity.PayOrIncomeEventDataBean;
import com.wenh.myapp.mapper.AllPayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllPayService {
    @Autowired
    private AllPayMapper allPayMapper;

    public int InsertPayEvent(AllPay allPay){
        return allPayMapper.InsertPayEvent(allPay);
    }

    public PayEventDataBean SelectAllPay(AllPay allPay) {
        PayEventDataBean payEventDataBean = new PayEventDataBean();
        List<AllPay> allPayList = allPayMapper.SelectPayEvent(allPay);
        int count = allPayList.size();
        payEventDataBean.setAllPayList(allPayList);
        payEventDataBean.setCount(count);
        return payEventDataBean;
    }

    public PayEventDataBean SelectAllPay() {
        PayEventDataBean payEventDataBean = new PayEventDataBean();
        List<AllPay> allPayList = allPayMapper.SelectAllPayEvent();
        int count = allPayList.size();
        payEventDataBean.setAllPayList(allPayList);
        payEventDataBean.setCount(count);
        return payEventDataBean;
    }

    public AllPay SelectAllPay(int id) {

        return allPayMapper.SelectDetailsPayEvent(id);
    }

    public int DeletePayEvent(int id) {
        return allPayMapper.DeletePayEvent(id);

    }

    public int UpdatePayEvent(AllPay allPay) {
        return allPayMapper.UpdatePayEvent(allPay);
    }

    public PayOrIncomeEventDataBean SelectPayEventDay(String account, String date, String month, String year) {
        List<AllPay> allPayList = allPayMapper.SelectPayEventDay(account, date, month, year, -1);
        int payCount = allPayList.size();
        List<AllPay> allIncomeList = allPayMapper.SelectPayEventDay(account, date, month, year, 1);
        int incomeCount = allIncomeList.size();
        PayOrIncomeEventDataBean payOrIncomeEventDataBean = new PayOrIncomeEventDataBean(payCount,incomeCount,allPayList,allIncomeList);

        return payOrIncomeEventDataBean;

    }
}
