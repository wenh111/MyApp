package com.wenh.myapp.controller;

import com.wenh.myapp.entity.SaveMoneyEventBean;
import com.wenh.myapp.entity.SaveMoneyEventListBean;
import com.wenh.myapp.entity.UDSaveMoneyEventBean;
import com.wenh.myapp.service.SaveMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/SaveMoney")
public class SaveMoneyController {
    @Autowired
    SaveMoneyService saveMoneyService;

    @PostMapping("/AddSaveMoneyEvent")
    public int addSaveMoneyEvent(@RequestBody SaveMoneyEventBean saveMoneyEventBean){
        return saveMoneyService.insertSaveMoneyEvent(saveMoneyEventBean);
    }

    @GetMapping()
    public SaveMoneyEventListBean selectAllSaveMoneyEvent(){
        return saveMoneyService.selectAllSaveMoneyEvent();
    }

    @GetMapping("/SelectSaveMoneyPlanEvent")
    public SaveMoneyEventListBean selectSaveMoneyPlanEvent(@RequestParam String account , @RequestParam String type){
        return saveMoneyService.selectAllSaveMoneyPlanEvent(account, type);
    }

    @PostMapping("/PunchOrDelete")
    public int PunchOrDelete(@RequestBody UDSaveMoneyEventBean udSaveMoneyEventBean, @RequestParam int isDelete){
        return saveMoneyService.punchCard(udSaveMoneyEventBean,isDelete);
    }
}
