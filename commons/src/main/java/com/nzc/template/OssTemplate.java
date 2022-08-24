package com.nzc.template;


import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.nzc.properties.OssProperties;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author Ning Zaichun
 */
public class OssTemplate {

    private OssProperties ossProperties;

    public OssTemplate(OssProperties ossProperties) {
        this.ossProperties = ossProperties;
    }

    public String test() {
        System.out.println(ossProperties.getBucketName());
        return "test";
    }

    public String upload(String filename, InputStream is) {
        // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
        String endpoint = ossProperties.getEndpoint();
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = ossProperties.getAccessKey();
        String accessKeySecret = ossProperties.getSecret();

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        String storePath = new SimpleDateFormat("yyyy/MM/dd").format(new Date()) + "/" + UUID.randomUUID() + filename.substring(filename.lastIndexOf("."));

        System.out.println(storePath);
        // 依次填写Bucket名称（例如examplebucket）和Object完整路径（例如exampledir/exampleobject.txt）。Object完整路径中不能包含Bucket名称。
        ossClient.putObject(ossProperties.getBucketName(), storePath, is);

        String url = ossProperties.getUrl() + storePath;

        // 关闭OSSClient。
        ossClient.shutdown();
        return url + "#" + storePath;
    }

    public void remove(String fileUrl) {
        // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
        String endpoint = ossProperties.getEndpoint();
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = ossProperties.getAccessKey();
        String accessKeySecret = ossProperties.getSecret();
        // 填写Bucket名称。
        String bucketName = ossProperties.getBucketName();
        // 填写文件完整路径。文件完整路径中不能包含Bucket名称。
        //2022/01/21/f0870eb3-4714-4fae-9fc3-35e72202f193.jpg
        String objectName = fileUrl;

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 删除文件或目录。如果要删除目录，目录必须为空。
        ossClient.deleteObject(bucketName, objectName);

        // 关闭OSSClient。
        ossClient.shutdown();
    }
}