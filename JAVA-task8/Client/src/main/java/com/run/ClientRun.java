package com.run;

import com.service.TbstudentService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientRun {
    static Logger logger = Logger.getLogger(ClientRun.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ClientApplicationContext.xml");
        TbstudentService tbstudentService = (TbstudentService) context.getBean("StudentRMIClient");
        logger.info(tbstudentService.selectByPrimaryKey(2));
    }
}
