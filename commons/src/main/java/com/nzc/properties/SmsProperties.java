package com.nzc.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Ning Zaichun
 */

@Data
@ConfigurationProperties(prefix = "nzc.sms")
public class SmsProperties {

    private String name;
}
