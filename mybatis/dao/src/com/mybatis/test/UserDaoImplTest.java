package com.mybatis.test;

import com.mybatis.dao.UserDao;
import com.mybatis.dao.UserDaoImpl;
import com.mybatis.po.User;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import java.io.InputStream;

/**
 * Created by xumingjie on 15/9/30.
 */
public class UserDaoImplTest extends TestCase {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {

        String resource = "SqlMapConfig.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    public void testFindUserById() throws Exception {
        //创建UserDao的对象
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        //调用UserDao的方法
        User user = userDao.findUserById(1);;

        System.out.println(user.getUsername());

    }

    public void testInsertUser() throws Exception {

    }

    public void testDeleteUser() throws Exception {

    }
}