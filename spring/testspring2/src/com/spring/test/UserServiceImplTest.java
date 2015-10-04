package com.spring.test;

import com.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by xumingjie on 15/10/4.
 */
public class UserServiceImplTest {

    @Test
    public void testAdd() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"beans.xml"});
        UserService userService = (UserService) applicationContext.getBean("userService");
        UserService userService2 = (UserService) applicationContext.getBean("userService");
        System.out.println(userService);
        System.out.println(userService2);
        userService.add("flippy");
    }
}