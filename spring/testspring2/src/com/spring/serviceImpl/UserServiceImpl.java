package com.spring.serviceImpl;

import com.spring.dao.UserDao;
import com.spring.daoImpl.UserDaoImpl;
import com.spring.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xumingjie on 15/10/4.
 */

@Component("userService")
//@Service("userService")
@Scope("prototype")
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;

    public void add(String username) {
        System.out.println("UserDaoImpl.add()");
        userDao.insert(username);
    }


//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

}
