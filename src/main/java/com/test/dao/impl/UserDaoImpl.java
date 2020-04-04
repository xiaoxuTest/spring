package com.test.dao.impl;

import com.test.dao.UserDao;
import com.test.vo.User;
import com.test.vo.UserMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Override
    public void addUser(User user) {
        String sql="insert into user (name,age,email,address) values(?,?,?,?)";
        jdbcTemplate.update(sql,user.getName(),user.getAge(),user.getEmail(),user.getAddress());
    }

    @Override
    public List<User> getUserInfoById(int id) {
        String sql="select * from user where id=?";
        List<User> user =jdbcTemplate.query(sql,new UserMapper(),id);
        return user;
    }
//1111
    @Override
    public List<User> getUserList() {
        String sql="select * from user";
        List<User> user =jdbcTemplate.query(sql,new UserMapper());
        return user;
    }

    @Override
    public void updateUser(User user) {
         String sql="update user set name=?,age=?,email=?,address=? where id=?";
         jdbcTemplate.update(sql,user.getName(),user.getAge(),user.getEmail(),user.getAddress(),user.getId());
    }

    @Override
    public void deleteUserById(int id) {
        String sql="delete from user where id=?";
        jdbcTemplate.update(sql,id);
    }
}
