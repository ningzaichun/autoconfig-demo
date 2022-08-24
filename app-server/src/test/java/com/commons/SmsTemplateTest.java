package com.commons;

import com.nzc.server.AppServerApplication;
import com.nzc.template.SmsTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Ning Zaichun
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppServerApplication.class)
public class SmsTemplateTest {

    @Autowired
    private SmsTemplate smsTemplate;

    @Test
    public void testSendSms(){
        smsTemplate.sendSms("17670090715","123456");
    }

}
