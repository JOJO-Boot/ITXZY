package com.service.imp;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.pojo.Message;
import com.util.MemcachedUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class SmsService {

    static Logger logger = Logger.getLogger(SmsService.class);
    @Resource
    private Message message;

    /**
     * 发送短信
     * @param phoneNumber
     * @return
     * @throws ClientException
     */
    public  SendSmsResponse sendSms(String phoneNumber) throws ClientException {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-zhengzhou", message.getAccessKeyId(), message.getAccessKeySecret());
        DefaultProfile.addEndpoint("cn-zhengzhou", "cn-zhengzhou", message.getProduct(), message.getDomain());
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        //使用post提交
        request.setMethod(MethodType.POST);
        //必填:待发送手机号
        request.setPhoneNumbers(phoneNumber);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("芸生培训");
        //必填:短信模板-可在短信控制台中找到,验证码模板，您的验证码为${code}
        request.setTemplateCode(message.getTemplateCode());
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        String  verifiedCode = String.valueOf(new Random().nextInt(899999)+100000); //生成6位数字验证码
        MemcachedUtil memcachedUtil = new MemcachedUtil();
        memcachedUtil.set("code",verifiedCode);
        logger.info("放入缓存中验证码为"+ verifiedCode);
        Map<String,Object> map = new HashMap<>();
        map.put("code",verifiedCode);
        request.setTemplateParam(JSON.toJSONString(map));
        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");
        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");
        //hint 此处可能会抛出异常，注意catch
        return acsClient.getAcsResponse(request);
    }

}
