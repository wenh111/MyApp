package com.wenh.myapp.mapper;

import com.wenh.myapp.entity.AllPay;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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


    AllPay getMonthSinceValues(@Param("year") String year,@Param("month") String month,
                               @Param("account") String account, int lastValues,@Param("category") String category);

    int getDatePayEventCount(@Param("account") String account,@Param("date") String date,@Param("category") String category);

    List<AllPay> SelectPayEventMonth(@Param("account") String account, @Param("date") String date,@Param("category") String category);

    List<AllPay> SelectPayEventDate(@Param("account") String account, @Param("year") String year,@Param("month") String month,int since, int perPages,@Param("category") String category);

    AllPay getMonthNextSinceValues(@Param("account")String account, int since, int lastValues,@Param("category") String category);

    //int getLastValuesID(@Param("month")String month, int i);
}
