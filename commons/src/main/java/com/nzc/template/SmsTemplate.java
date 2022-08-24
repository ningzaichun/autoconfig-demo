package com.nzc.template;

import com.nzc.properties.SmsProperties;

/**
 * @author Ning Zaichun
 */
public class SmsTemplate {

    private SmsProperties properties;

    public SmsTemplate(SmsProperties properties) {
        this.properties = properties;
    }

    public void sendSms(String mobile, String code){
        System.out.println(properties.getName()+"=="+mobile+"===="+code);
    }
}
