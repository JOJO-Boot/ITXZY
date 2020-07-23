package com.controller;


import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

@Controller
public class ImagesController {

    private static String endpoint = "http://oss-cn-beijing.aliyuncs.com";
    private static String accessKeyId = "";
    private static String accessKeySecret = "";
    // Bucket命名规范如下：只能包括小写字母，数字和短横线（-），必须以小写字母或者数字开头，长度必须在3-63字节之间。
    private static String bucketName = "qzn2077";
    // Object命名规范如下：使用UTF-8编码，长度必须在1-1023字节之间，不能以“/”或者“\”字符开头。
    private static String firstKey = "my-first-key";


    @RequestMapping("/upLoad")
    public String upload() {
        return "upload";
    }

    @ResponseBody
    @RequestMapping(value = "/photoupload")
    public String myphotoupload(HttpServletRequest request) {
        JSONObject ret = new JSONObject();
        String key = "";
        String fileNames = "";
        ret.put("success", false);
        ret.put("msg", "请求失败[PU01]");
        try {
            StandardMultipartHttpServletRequest req = (StandardMultipartHttpServletRequest) request;
            Iterator<String> iterator = req.getFileNames();
            while (iterator.hasNext()) {
                MultipartFile file = req.getFile(iterator.next());
                fileNames = file.getOriginalFilename();
                InputStream input = file.getInputStream();

                // 创建OSSClient实例
                OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
                // 上传文件流
                ossClient.putObject(bucketName, firstKey + fileNames, input);
                ossClient.shutdown();
            }
            ret.put("success", true);
            ret.put("msg", key + fileNames);
            System.out.println(("图片上传阿里云 name=" + key + fileNames));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret.getString("msg");
    }
}
