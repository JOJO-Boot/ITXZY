import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import rmitest.HelloRMIService;

public class ClientRMITest {
    static Logger logger = Logger.getLogger(ClientRMITest.class);

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ClientApplicationContext.xml");
        context.getBean("ClientRmiTest");
        HelloRMIService helloRMIService = (HelloRMIService)  context.getBean("ClientRmiTest");
        logger.info(helloRMIService.sayHi("rmitest"));
    }
}
