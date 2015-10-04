package com.spring.aop.service.impl;

import com.spring.aop.service.PersonService;

/**
 * Created by xumingjie on 15/10/4.
 */
public class PersonServiceBean implements PersonService {

    private String user = null;

    public PersonServiceBean(String user) {
        this.user = user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String save(String user) {
        System.out.println("PersonServiceBean.save() is running");
        return user;
    }

    public void update(String user) {
        System.out.println("PersonServiceBean.update() is running");
    }
}
