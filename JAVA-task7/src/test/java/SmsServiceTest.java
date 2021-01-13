import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.service.imp.SmsService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class SmsServiceTest {

    static Logger logger = Logger.getLogger(SmsServiceTest.class);

    @Autowired
    SmsService smsService;

    @Test
    public void sendSms() throws ClientException, InterruptedException {
        final String phoneNumber = "15093390769";
        //发送短信
        SendSmsResponse sendSmsResponse= smsService.sendSms(phoneNumber);
        logger.info("短信接口返回数据----------------");
        logger.info("Code=" + sendSmsResponse.getCode());
        logger.info("Message=" + sendSmsResponse.getMessage());
        logger.info("RequestId=" + sendSmsResponse.getRequestId());
        logger.info("BizId=" + sendSmsResponse.getBizId());

        Thread.sleep(3000L);
    }
}