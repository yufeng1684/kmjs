package org.kmjs.springbootmybatis.dao.impl;

import org.kmjs.springbootmybatis.dao.UserDao;
import org.kmjs.springbootmybatis.model.User;
import org.kmjs.springbootmybatis.model.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveUser(User user) {
        return userMapper.insert(user);
    }
}
