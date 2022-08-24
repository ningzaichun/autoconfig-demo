package com.nzc;

import com.nzc.properties.OssProperties;
import com.nzc.properties.SmsProperties;
import com.nzc.template.OssTemplate;
import com.nzc.template.SmsTemplate;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @Author: Ning Zaichun
 * version 1.0
 */
@EnableConfigurationProperties({
        SmsProperties.class,
        OssProperties.class
})
public class CommonAutoConfig {

    @Bean
    public SmsTemplate smsTemplate(SmsProperties smsProperties){
        return new SmsTemplate(smsProperties);
    }

    @Bean
    public OssTemplate ossTemplate(OssProperties ossProperties){
        return new OssTemplate(ossProperties);
    }

}
