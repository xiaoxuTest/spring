package com.test.dao;

import com.test.vo.User;

import java.util.List;

/*
* @author xiaoxu
* */
public interface UserDao {

    public void addUser(User user);
    public List<User> getUserInfoById(int id);
    public List<User> getUserList();
    public void updateUser(User user);
    public void deleteUserById(int id);
}
