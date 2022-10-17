package com.wenh.myapp.controller;

import com.wenh.myapp.entity.AllPay;
import com.wenh.myapp.entity.OCRInsertPayEvent;
import com.wenh.myapp.service.PayEventOCRInsertService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/OCRInsert")
public class PayEventOCRInsert {
    @Resource
    PayEventOCRInsertService payEventOCRInsertService;

    @PostMapping("/wechat")
    public int InsertEvent(@RequestBody List<AllPay> allPayList){
        return payEventOCRInsertService.wechatInsert(allPayList);
    }

}
