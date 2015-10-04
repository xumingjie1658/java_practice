package com.spring.first_demo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xumingjie on 15/10/4.
 */
public class UserDaoTest {

    @Test
    public void testAdd() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"beans.xml"});
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.add("flippy","asdasd");
    }
}