package com.wenh.myapp.controller;


import com.wenh.myapp.entity.AllPay;
import com.wenh.myapp.entity.PayEventDataBean;
import com.wenh.myapp.entity.PayOrIncomeEventDataBean;
import com.wenh.myapp.service.AllPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/AllPay")
public class AllPayController {
    @Autowired
    AllPayService allPayService;

    @GetMapping("/AllPayEvent")
    private PayEventDataBean AllPayEvent(){
        return allPayService.SelectAllPay();
    }

    @GetMapping
    private PayEventDataBean SelectAllPay(@RequestParam String account, @RequestParam String category
            , @RequestParam String date, @RequestParam String month, @RequestParam String year) {
        AllPay allPay = new AllPay();
        allPay.setAccount(account);
        allPay.setCategory(category);
        allPay.setDate(date);
        allPay.setMonth(month);
        allPay.setYear(year);
        return allPayService.SelectAllPay(allPay);
    }

    @GetMapping("/Details")
    private AllPay SelectAllPay(@RequestParam int id) {
        return allPayService.SelectAllPay(id);
    }

    @PostMapping("/AddEvent")
    private int InsertEvent(@RequestBody AllPay allPay) {
        return allPayService.InsertPayEvent(allPay);
    }

    @PostMapping("/deletePayEvent")
    private int DeleteEvent(@RequestParam int id) {
        return allPayService.DeletePayEvent(id);
    }

    @PostMapping("/UpdatePayEvent")
    private int UpdatePayEvent(@RequestBody AllPay allPay) {
        return allPayService.UpdatePayEvent(allPay);
    }

    @GetMapping("/PayEventStatistics")
    private PayOrIncomeEventDataBean SelectPayEventDay(@RequestParam String account, @RequestParam String date,
                                                       @RequestParam String month, @RequestParam String year) {
        return allPayService.SelectPayEventDay(account,date,month,year);
    }
}
