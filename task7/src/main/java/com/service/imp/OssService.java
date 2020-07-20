/**
 * 示例说明
 * 
 * HelloOSS是OSS Java SDK的示例程序，您可以修改endpoint、accessKeyId、accessKeySecret、bucketName后直接运行。
 * 运行方法请参考README。
 * 
 * 本示例中的并不包括OSS Java SDK的所有功能，详细功能及使用方法，请参看“SDK手册 > Java-SDK”，
 * 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/preface.html?spm=5176.docoss/sdk/java-sdk/。
 * 
 * 调用OSS Java SDK的方法时，抛出异常表示有错误发生；没有抛出异常表示成功执行。
 * 当错误发生时，OSS Java SDK的方法会抛出异常，异常中包括错误码、错误信息，详细请参看“SDK手册 > Java-SDK > 异常处理”，
 * 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/exception.html?spm=5176.docoss/api-reference/error-response。
 * 
 * OSS控制台可以直观的看到您调用OSS Java SDK的结果，OSS控制台地址是：https://oss.console.aliyun.com/index#/。
 * OSS控制台使用方法请参看文档中心的“控制台用户指南”， 指南的来链接地址是：https://help.aliyun.com/document_detail/oss/getting-started/get-started.html?spm=5176.docoss/user_guide。
 * 
 * OSS的文档中心地址是：https://help.aliyun.com/document_detail/oss/user_guide/overview.html。
 * OSS Java SDK的文档地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/install.html?spm=5176.docoss/sdk/java-sdk。
 * 
 */

package com.service.imp;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.lang.annotation.*;
import java.util.List;
import java.util.UUID;

public class OssService {
    static Logger logger = Logger.getLogger(OssService.class);
    /**
     * OSS基本配置
     */
    // endpoint是访问OSS的域名。如果您已经在OSS的控制台上 创建了Bucket，请在控制台上查看域名。
    // endpoint的格式形如“http://oss-cn-hangzhou.aliyuncs.com/”，注意http://后不带bucket名称，
    private static String endpoint = "http://oss-cn-beijing.aliyuncs.com";
    private static String accessKeyId = "LTAI4Fy6d5zNufgGun4WYprY";
    private static String accessKeySecret = "6auTJl31zo6UdoyqQFZZAUyQbx7BFO";
    // Bucket命名规范如下：只能包括小写字母，数字和短横线（-），必须以小写字母或者数字开头，长度必须在3-63字节之间。
    private static String bucketName = "qzn2077";
    // Object命名规范如下：使用UTF-8编码，长度必须在1-1023字节之间，不能以“/”或者“\”字符开头。
    private static String firstKey = "my-first-key";

    public String upPhoto(MultipartFile multipartFile) {

        /**
         * 生成OSSClient
         */
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        //使用UUID给图片重命名，并去掉 -
        String name = UUID.randomUUID().toString().replaceAll("-","");
        //获取图片名称
        String ext = multipartFile.getOriginalFilename();
        //获取图片的后缀
        String suffix = ext.substring(ext.lastIndexOf("."));
        String photoName = name + suffix;

        try {
            //判断bucket是否存在
            if(ossClient.doesBucketExist(bucketName)){
                logger.info("已经创建过Bucket,名称为:" + bucketName);
            }else {
                logger.info("Bucket不存在，请去创建Bucket");
                ossClient.createBucket(bucketName);
            }
            // Object是OSS存储数据的基本单元，称为OSS的对象，也被称为OSS的文件。详细描述请参看“开发人员指南 > 基本概念 > OSS基本概念介绍”。
            // Object命名规范如下：使用UTF-8编码，长度必须在1-1023字节之间，不能以“/”或者“\”字符开头。
            // oss中没有文件夹的概念，如果想传到对应的目录下，可以在object名称前添加对应的路径。
            String fileName = "minImage/" + photoName;

            // 创建PutObjectRequest对象，构造上传请求。
            // <yourLocalFile>由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。
            // 数据流上传，将 MultipartFile 转为 InputStream，适用于所有的InputStream子类。
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,fileName,new ByteArrayInputStream(multipartFile.getBytes()));

            // 如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
            ObjectMetadata metadata = new ObjectMetadata();
            // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
            // metadata.setObjectAcl(CannedAccessControlList.Private);

            // 这里也能设置content-disposition，但是不知道设置为什么可以取消强制下载。
//            metadata.setContentDisposition();
            // 指定Content-Type
            // metadata.setContentType("application/octet-stream");
            metadata.setContentType("image");
            putObjectRequest.setMetadata(metadata);
            // 上传文件
            ossClient.putObject(putObjectRequest);

            // 上传文件。<yourLocalFile>由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。
            // 数据流上传，将 MultipartFile 转为 InputStream，适用于所有的InputStream子类。
//            ossClient.putObject(bucketName,fileName,new ByteArrayInputStream(multipartFile.getBytes()));

            // 关闭OSSClient。
            ossClient.shutdown();
            // 添加图片处理样式有两种方式，此处是添加样式对应的代码（等比缩小为30%），还可以添加样式的名称，如“ ?x-oss-process=style/30suoluetu ”
            String url = "https://jnshu-7012.oss-cn-beijing.aliyuncs.com/" + fileName + "?x-oss-process=image/auto-orient,1/resize,p_30/quality,q_90";
//            String url2 = "https://jnshu-7012.oss-cn-beijing.aliyuncs.com/" + fileName + "?x-oss-process=style/30suoluetu";
            return url;
        }catch (OSSException oe){
            logger.error("出现异常1，异常为" + oe.getMessage());
        }catch (ClientException ce){
            logger.error("出现异常2，异常为" + ce.getMessage());
        }catch (Exception e){
            logger.error("出现异常为3" + e.getMessage());
        }
        return null;
    }


}