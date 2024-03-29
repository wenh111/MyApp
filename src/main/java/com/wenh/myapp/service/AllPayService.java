package com.wenh.myapp.service;

import com.wenh.myapp.entity.AllPay;
import com.wenh.myapp.entity.MonthPayEventDataBean;
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

    public int InsertPayEvent(AllPay allPay) {
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
        PayOrIncomeEventDataBean payOrIncomeEventDataBean = new PayOrIncomeEventDataBean(payCount, incomeCount, allPayList, allIncomeList);

        return payOrIncomeEventDataBean;

    }

    public MonthPayEventDataBean getMonthPayEvent(String account, String year, String month, int since, int perPages, String category, int selectType, String day) {

        System.out.println("account ====== " + account);
        /*System.out.println("category ====== " + category);
        System.out.println("month ====== " + month);
        System.out.println("year ====== " + year);*/
        MonthPayEventDataBean monthPayEventDataBean = new MonthPayEventDataBean();
        if (selectType == 2) {
            List<AllPay> allPayList = allPayMapper.getDayPayEvent(account, day, category);
            monthPayEventDataBean.setPerPage(0);
            monthPayEventDataBean.setSince(-1);
            monthPayEventDataBean.setAllPayList(allPayList);
            monthPayEventDataBean.setCount(allPayList.size());

        } else {
            if (since == -1 && perPages == -1) {
                String date;
                //获取的首条记录
                AllPay allPay = allPayMapper.getMonthSinceValues(year, month, account, 0, category);
                if (allPay == null) {
                    System.out.println("account ======= " + account);
                    monthPayEventDataBean = new MonthPayEventDataBean(null, 0, 0, 0);
                } else {
                    //id = allPay.getId();
                    date = allPay.getDate();
                    //获取首天的记录数量
                    int count = allPayMapper.getDatePayEventCount(account, date, category);
                    //monthPayEventDataBean.setSince(allPayMapper.getMonthSinceValues(year, month, account, count - 1).getInt_date());
                    //标识
                    monthPayEventDataBean.setSince(allPay.getInt_date());
                    //首天的数据
                    List<AllPay> allPayList = allPayMapper.SelectPayEventMonth(account, date, category);
                    monthPayEventDataBean.setAllPayList(allPayList);
                    //首天的数据数量
                    monthPayEventDataBean.setCount(allPayList.size());
                    //获取下一天的数据
                    AllPay nextDateList = allPayMapper.getMonthSinceValues(year, month, account, count, category);
                    if (selectType == 0) {
                        if (nextDateList == null || !nextDateList.getMonth().equals(month)) {
                            monthPayEventDataBean.setPerPage(0);
                        } else {
                            String nextDate = nextDateList.getDate();
                            int nextDateCount = allPayMapper.getDatePayEventCount(account, nextDate, category);
                            //下一天的数据数量
                            monthPayEventDataBean.setPerPage(nextDateCount);
                        }
                    } else {
                        if (nextDateList == null || !nextDateList.getYear().equals(year)) {
                            monthPayEventDataBean.setPerPage(0);
                        } else {
                            String nextDate = nextDateList.getDate();
                            int nextDateCount = allPayMapper.getDatePayEventCount(account, nextDate, category);
                            //下一天的数据数量
                            monthPayEventDataBean.setPerPage(nextDateCount);
                        }
                    }
                }


            } else {
                System.out.println("account ====== " + account);
                System.out.println("category ====== " + category);
                System.out.println("since ====== " + since);
                System.out.println("perPages ====== " + perPages);

                //获取今天的数据
                //0803 2
                List<AllPay> allPayList = allPayMapper.SelectPayEventDate(account, year, month, since, perPages, category);
                int count = allPayList.size();
                //获取今天的数据
                monthPayEventDataBean.setAllPayList(allPayList);
                //今天的数据量
                monthPayEventDataBean.setCount(count);
                //标识
                monthPayEventDataBean.setSince(allPayList.get(0).getInt_date());
                //获取下一天的数据量
                System.out.println("============ ");
                System.out.println("since ====== " + since);
                AllPay nextDateList = allPayMapper.getMonthNextSinceValues(account, allPayList.get(0).getInt_date(), 0, category);
                if (selectType == 0) {
                    if (nextDateList == null || !nextDateList.getMonth().equals(month)) {
                        monthPayEventDataBean.setPerPage(0);
                    } else {
                        String nextDate = nextDateList.getDate();
                        System.out.println("nextDate ====== " + nextDate);
                        int nextDateCount = allPayMapper.getDatePayEventCount(account, nextDate, category);
                        System.out.println("nextDateCount ====== " + nextDateCount);
                        monthPayEventDataBean.setPerPage(nextDateCount);
                    }
                } else {
                    if (nextDateList == null || !nextDateList.getYear().equals(year)) {
                        monthPayEventDataBean.setPerPage(0);
                    } else {
                        String nextDate = nextDateList.getDate();
                        System.out.println("nextDate ====== " + nextDate);
                        int nextDateCount = allPayMapper.getDatePayEventCount(account, nextDate, category);
                        System.out.println("nextDateCount ====== " + nextDateCount);
                        monthPayEventDataBean.setPerPage(nextDateCount);
                    }
                }


            }
        }


        return monthPayEventDataBean;
    }
}
