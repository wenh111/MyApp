package com.wenh.myapp.mapper;

import com.wenh.myapp.entity.AllPay;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OCRInsertMapper {
    int wechatInsertSql(List<AllPay> allPayList);
}
