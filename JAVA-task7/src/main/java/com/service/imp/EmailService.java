package com.service.imp;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.controller.VerifyController;
import com.pojo.Email;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    static Logger logger = Logger.getLogger(EmailService.class);
    @Autowired
    private Email email;
    public void sendMail(String address) {
        // 如果是除杭州region外的其它region（如新加坡、澳洲Region），需要将下面的”cn-hangzhou”替换为”ap-southeast-1”、或”ap-southeast-2”。
        IClientProfile profile = DefaultProfile.getProfile(email.getRegion(), email.getAccessKeyId(), email.getAccessKeySecret());
        // 如果是除杭州region外的其它region（如新加坡region）， 需要做如下处理
        //try {
        //DefaultProfile.addEndpoint("dm.ap-southeast-1.aliyuncs.com”, "ap-southeast-1”, "Dm”,  "dm.ap-southeast-1.aliyuncs.com”);
        //} catch (ClientException e) {
        //e.printStackTrace();
        //}
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        try {
            //request.setVersion("2017-06-22”);// 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22
//            request.setAccountName(email.getAccountName());
//            request.setFromAlias(email.getFromAlias());
//            request.setAddressType(1);
//            request.setTagName(email.getTagName());
//            request.setReplyToAddress(true);
//            request.setToAddress(address);
            request.setAccountName("jojonian@email.mongen.top");
            request.setFromAlias("花泽香菜");
            request.setAddressType(1);
            request.setTagName("email");
            request.setReplyToAddress(true);
            request.setToAddress("1589690721@qq.com");
            request.setSubject("婚礼邀请函");
            request.setHtmlBody("很遗憾我选择了他，但是我不会忘了你的");
            //可以给多个收件人发送邮件，收件人之间用逗号分开，批量发信建议使用BatchSendMailRequest方式
            //request.setToAddress("邮箱1,邮箱2”);
//            request.setSubject(email.getSubject());
            //如果采用byte[].toString的方式的话请确保最终转换成utf-8的格式再放入htmlbody和textbody，若编码不一致则会被当成垃圾邮件。
            //注意：文本邮件的大小限制为3M，过大的文本会导致连接超时或413错误
//            request.setHtmlBody(email.getHtmlBody());
            //SDK 采用的是http协议的发信方式, 默认是GET方法，有一定的长度限制。
            //若textBody、htmlBody或content的大小不确定，建议采用POST方式提交，避免出现uri is not valid异常
            request.setMethod(MethodType.POST);
            //开启需要备案，0关闭，1开启
            //request.setClickTrace("0”);
            //如果调用成功，正常返回httpResponse；如果调用失败则抛出异常，需要在异常中捕获错误异常码；错误异常码请参考对应的API文档;
            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
            logger.info("发送邮件");
        } catch (ServerException e) {
            //捕获错误异常码
            logger.info("ErrCode : " + e.getErrCode());
            e.printStackTrace();
        } catch (ClientException e) {
            //捕获错误异常码
            logger.info("ErrCode : " + e.getErrCode());
            e.printStackTrace();
        }
    }
}
