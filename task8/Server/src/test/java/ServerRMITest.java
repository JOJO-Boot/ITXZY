import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServerRMITest {

    static Logger logger = Logger.getLogger(ServerRMITest.class);

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ServerApplicationContext.xml");
        context.getBean("ServerRmiTest");
        logger.info("================RMI已经启动========================");
    }
}
