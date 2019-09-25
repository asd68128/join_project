package com.sl.automobile.service.impl;

import com.sl.automobile.service.SendSmsService;
import com.sl.automobile.utils.AliyunSms;
import org.springframework.stereotype.Service;

/**
 * Created by happy on 2019/9/20.
 */
@Service
public class SendSmsImpl implements SendSmsService {
    @Override
    public String sendSms(String phoneNum) {
        String Message = new AliyunSms().sendSmsCode(phoneNum);
        System.out.println("这是调用短信的具体"+Message);
        return Message;
    }

    @Override
    public boolean checkSmsCode(String phoneNum, String smsCode) {
        boolean b = new AliyunSms().checkSmsCode(phoneNum, smsCode);
        return b;
    }

}
