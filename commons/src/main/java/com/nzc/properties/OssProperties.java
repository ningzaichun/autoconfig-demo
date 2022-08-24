package com.nzc.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Ning Zaichun
 */
@Data
@ConfigurationProperties(prefix = "nzc.oss")
public class OssProperties {

    private String accessKey; 
    private String secret;
    private String bucketName;
    private String url;
    private String endpoint;
}