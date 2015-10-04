package com.spring.test;

import com.spring.aop.service.PersonService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xumingjie on 15/10/4.
 */
public class AOPXMLTest {

    @Test
    public void instanceSpring(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        PersonService personService = (PersonService)context.getBean("personService");
        personService.save("Jamson");
    }
}
