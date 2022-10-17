package com.wenh.myapp.service;

import com.wenh.myapp.entity.AllPay;
import com.wenh.myapp.mapper.OCRInsertMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayEventOCRInsertService {
    @Autowired
    private OCRInsertMapper ocrInsertMapper;
    public int wechatInsert(List<AllPay> allPayList) {
        return ocrInsertMapper.wechatInsertSql(allPayList);
    }
}
