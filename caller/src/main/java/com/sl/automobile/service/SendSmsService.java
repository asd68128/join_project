package com.sl.automobile.service;

/**
 * Created by happy on 2019/9/20.
 */
public interface SendSmsService {
    public String sendSms(String phoneNum);
    public boolean checkSmsCode(String phoneNum, String smsCode);
}
