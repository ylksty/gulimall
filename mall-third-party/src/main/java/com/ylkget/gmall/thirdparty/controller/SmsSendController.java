package com.ylkget.gmall.thirdparty.controller;

import com.ylkget.common.utils.R;
import com.ylkget.gmall.thirdparty.componet.SmsComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * SmsSendController
 * </p>
 *
 * @author joe 2021/2/23 10:54
 */
@RestController
@RequestMapping("/sms")
public class SmsSendController {


    @Autowired
    SmsComponent smsComponent;

    /**
     * 提供给别的服务进行调用
     * @param phone
     * @param code
     * @return
     */
    @GetMapping("/sendcode")
    public R sendCode(@RequestParam("phone") String phone, @RequestParam("code") String code){
//        smsComponent.sendSmsCode(phone,code);
        return R.ok();
    }
}
