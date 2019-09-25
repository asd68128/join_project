package com.sl.automobile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alipay.api.AlipayApiException;
import com.sl.automobile.pojo.AlipayBean;
import com.sl.automobile.service.PayService;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 订单接口
 *
 * @author Louis
 * @date Dec 12, 2018
 */
/*@RestController()*/
/*@RequestMapping("order")*/
@Controller
public class OrderController {

    @Autowired
    private PayService payService;
/*
     *//**
     * 阿里支付
     * @param tradeNo
     * @param subject
     * @param amount
     * @param body
     * @return
     * @throws AlipayApiException
     */
    /*@PostMapping(value = "alipay")*/

    @RequestMapping("/My")
    public String pay(){
        return "pay";
    }

    @ResponseBody
    @RequestMapping("/Pay")
    public String alipay(String  outTradeNo, String subject, String totalAmount, String body) throws AlipayApiException {
        AlipayBean alipayBean = new AlipayBean();
        alipayBean.setOut_trade_no(outTradeNo);
        alipayBean.setSubject(subject);
        alipayBean.setTotal_amount(totalAmount);
        alipayBean.setBody(body);
        System.out.println(alipayBean);
        return payService.aliPay(alipayBean);

    }
}

