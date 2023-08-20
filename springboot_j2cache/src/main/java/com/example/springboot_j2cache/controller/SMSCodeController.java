package com.example.springboot_j2cache.controller;



import com.example.springboot_j2cache.domain.SMSCode;
import com.example.springboot_j2cache.service.SMSCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sms")
public class SMSCodeController {

    @Autowired
    private SMSCodeService smsCodeService;


    @GetMapping
    public String getCode(String tele) {
        String code = smsCodeService.sendCodeToSMS(tele);
        return code;
    }

    @PostMapping
    public boolean checkCode(@RequestBody SMSCode smsCode) {
        return smsCodeService.checkCode(smsCode);
    }
}
