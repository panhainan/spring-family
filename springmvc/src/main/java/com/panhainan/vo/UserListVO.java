package com.panhainan.vo;

import com.panhainan.entity.User;

import java.util.List;

public class UserListVO {
    private List<User> userList;

    @Override
    public String toString() {
        return "UserListVO{" +
                "userList=" + userList +
                '}';
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
