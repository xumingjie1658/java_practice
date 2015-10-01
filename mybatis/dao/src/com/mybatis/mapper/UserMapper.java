package com.mybatis.mapper;

import com.mybatis.po.User;
import com.mybatis.po.UserCustom;
import com.mybatis.po.UserQueryVo;

import java.util.List;

/**
 * Created by xumingjie on 15/9/30.
 */
public interface  UserMapper {

    // 根据id查询用户信息
    public User findUserById(int id) throws Exception;

    public List<User> findUserByName(String name) throws Exception;

    // 添加用户信息
    public void insertUser(User user) throws Exception;

    // 删除用户信息
    public void deleteUser(int id) throws Exception;

    //用户信息综合查询
    public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;

    //根据id查询用户信息,使用resultMap输出
    public User findUserByIdResultMap(int id) throws Exception;
}
