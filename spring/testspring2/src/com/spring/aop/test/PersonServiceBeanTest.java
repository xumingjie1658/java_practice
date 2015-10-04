package com.spring.aop.test;

import com.spring.aop.service.PersonService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by xumingjie on 15/10/4.
 */
public class PersonServiceBeanTest {

    @Test
    public void testSave() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        PersonService personService = (PersonService)context.getBean("personService");
        personService.save("flippy");
    }
}