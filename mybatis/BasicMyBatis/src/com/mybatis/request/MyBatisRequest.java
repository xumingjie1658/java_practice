package com.mybatis.request;

import com.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by xumingjie on 15/9/30.
 */
public class MyBatisRequest {

    @Test
    public void findUserByIdTest() {
        //mybatis配置文件
        SqlSession sqlSession = null;
        try {
            String resource = "SqlMapConfig.xml";

            //得到配置文件流
            InputStream inputStream = Resources.getResourceAsStream(resource);

            //创建会话工厂,传入mybatis配置文件
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //通过工厂得到sqlSession
            sqlSession = sqlSessionFactory.openSession();

            //通过sqlSession操作数据库
            //第一个参数:映射文件中的statementd的id,等于=namespace+"."+statementId
            //指定和映射文件中所匹配的parameterTypel类型的参数
            User user = sqlSession.selectOne("test.findUserById", 1);

            System.out.println(user.getUsername());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    //根据用户名称模糊查询用户列表
    @Test
    public void findUserByName() {
        SqlSession sqlSession = null;
        try {
            String resource = "SqlMapConfig.xml";

            //得到配置文件流
            InputStream inputStream = Resources.getResourceAsStream(resource);

            //创建会话工厂,传入mybatis配置文件
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //通过工厂得到sqlSession
            sqlSession = sqlSessionFactory.openSession();

            //通过sqlSession操作数据库
            //第一个参数:映射文件中的statementd的id,等于=namespace+"."+statementId
            //指定和映射文件中所匹配的parameterTypel类型的参数
            List<User> users = sqlSession.selectList("test.findUserByName", "小明");

            for(int i = 0; i < users.size(); i++) {
                System.out.println(users.get(i).getUsername());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    //添加用户信息
    @Test
    public void insertUser() {
        SqlSession sqlSession = null;
        try {
            String resource = "SqlMapConfig.xml";

            //得到配置文件流
            InputStream inputStream = Resources.getResourceAsStream(resource);

            //创建会话工厂,传入mybatis配置文件
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //通过工厂得到sqlSession
            sqlSession = sqlSessionFactory.openSession();

            //通过sqlSession操作数据库
            //第一个参数:映射文件中的statementd的id,等于=namespace+"."+statementId
            //指定和映射文件中所匹配的parameterTypel类型的参数

            User user = new User();
            user.setUsername("mannix");
            user.setBirthday(new Date());
            user.setSex("1");
            user.setAddress("安徽省");

            System.out.println(user.getId());

            sqlSession.insert("test.insertUser", user);
            sqlSession.commit();

            System.out.println(user.getId());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    //删除用户信息
    @Test
    public void deleteUser() {
        SqlSession sqlSession = null;
        try {
            String resource = "SqlMapConfig.xml";

            //得到配置文件流
            InputStream inputStream = Resources.getResourceAsStream(resource);

            //创建会话工厂,传入mybatis配置文件
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //通过工厂得到sqlSession
            sqlSession = sqlSessionFactory.openSession();

            //通过sqlSession操作数据库
            //第一个参数:映射文件中的statementd的id,等于=namespace+"."+statementId
            //指定和映射文件中所匹配的parameterTypel类型的参数

            sqlSession.delete("test.deleteUser", 2);

            sqlSession.commit();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    //更新用户信息
    @Test
    public void updateUser() {
        SqlSession sqlSession = null;
        try {
            String resource = "SqlMapConfig.xml";

            //得到配置文件流
            InputStream inputStream = Resources.getResourceAsStream(resource);

            //创建会话工厂,传入mybatis配置文件
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //通过工厂得到sqlSession
            sqlSession = sqlSessionFactory.openSession();

            //通过sqlSession操作数据库
            //第一个参数:映射文件中的statementd的id,等于=namespace+"."+statementId
            //指定和映射文件中所匹配的parameterTypel类型的参数
            User user = new User();
            user.setId(5);
            user.setUsername("edwin");
            user.setBirthday(new Date());
            user.setSex("1");
            user.setAddress("美国休斯敦");

            sqlSession.update("test.updateUser", user);

            sqlSession.commit();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
