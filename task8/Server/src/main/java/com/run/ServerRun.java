package com.run;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServerRun {
    static Logger logger = Logger.getLogger(ServerRun.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ServerApplicationContext.xml");
        context.getBean("StudentRMIService");
        logger.info("===================================     Student  RMI  is   Ready   ===========================================");
    }
}
