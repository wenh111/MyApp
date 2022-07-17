package com.wenh.myapp.mapper;

import com.wenh.myapp.entity.AllPay;
import com.wenh.myapp.entity.PayEventDataBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AllPayMapper {

    int InsertPayEvent(AllPay allPay);

    List<AllPay> SelectPayEvent(AllPay allPay);


    List<AllPay> SelectAllPayEvent();

    AllPay SelectDetailsPayEvent(int id);

    int DeletePayEvent(int id);

    int UpdatePayEvent(AllPay allPay);

    List<AllPay> SelectPayEventDay(String account, String date, String month, String year, int isCost);


}
