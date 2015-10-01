package com.mybatis.po;

import java.util.List;

/**
 * Created by xumingjie on 15/9/30.
 */
public class UserQueryVo {

    // 在这里包装所需要的查询条件

    // 用户查询条件
    private List<Integer> ids;

    private UserCustom userCustom;

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

}
