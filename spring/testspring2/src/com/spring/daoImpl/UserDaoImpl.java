package com.spring.daoImpl;

import com.spring.dao.UserDao;
import org.springframework.stereotype.Component;

/**
 * Created by xumingjie on 15/10/4.
 */

@Component("userDao")

public class UserDaoImpl implements UserDao {
    public void insert(String username) {
        System.out.println("add " + username + " success");
    }
}
