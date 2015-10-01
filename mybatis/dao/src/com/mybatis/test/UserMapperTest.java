package com.mybatis.test;

import com.mybatis.mapper.UserMapper;
import com.mybatis.po.User;
import com.mybatis.po.UserCustom;
import com.mybatis.po.UserQueryVo;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xumingjie on 15/9/30.
 */
public class UserMapperTest extends TestCase {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {

        String resource = "SqlMapConfig.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    @Test
    public void testFindUserById() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findUserById(1);

        System.out.print(user.getUsername());

        sqlSession.close();

    }

    @Test
    public void testFindUserByName() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = userMapper.findUserByName("小明");

        for(int i = 0; i < users.size(); i++){
            System.out.print(users.get(i).getUsername());
        }

        sqlSession.close();
    }

    @Test
    public void testFindUserList() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserQueryVo userQueryVo = new UserQueryVo();

        UserCustom userCustom = new UserCustom();

        //userCustom.setSex("1");
        userCustom.setUsername("小明");
        userQueryVo.setUserCustom(userCustom);

        List<Integer> ids = new ArrayList<Integer>();
        ids.add(3);
        ids.add(7);
        userQueryVo.setIds(ids);
        List<UserCustom> users = userMapper.findUserList(userQueryVo);

        for(int i = 0; i < users.size(); i++){
            System.out.println(users.get(i).getUsername());
        }

        sqlSession.close();
    }

    @Test
    public void testFindUserByIdResultMap() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findUserByIdResultMap(1);

        System.out.print(user.getUsername());

        sqlSession.close();

    }
}