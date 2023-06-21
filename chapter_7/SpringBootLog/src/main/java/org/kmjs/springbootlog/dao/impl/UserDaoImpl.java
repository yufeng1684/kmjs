package org.kmjs.springbootlog.dao.impl;

import org.kmjs.springbootlog.dao.UserDao;
import org.kmjs.springbootlog.model.User;
import org.kmjs.springbootlog.model.mapper.UserMapper;
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
