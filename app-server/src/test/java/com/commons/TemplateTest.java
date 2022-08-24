package com.commons;

import com.nzc.server.AppServerApplication;
import com.nzc.template.OssTemplate;
import com.nzc.template.SmsTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author Ning Zaichun
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppServerApplication.class)
public class TemplateTest {

    @Autowired
    private OssTemplate ossTemplate;

    @Test
    public void testOss(){
        String s = ossTemplate.test();
        System.out.println(s);
    }

    @Test
    public void testUpload(){
        try {
            File file = new File("D:\\evectionflow01.png");
            InputStream inputStream = new FileInputStream(file);
            ossTemplate.upload("123.jpg",inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private SmsTemplate smsTemplate;

    @Test
    public void testSendSms(){
        smsTemplate.sendSms("17670090715","123456");
    }

}
