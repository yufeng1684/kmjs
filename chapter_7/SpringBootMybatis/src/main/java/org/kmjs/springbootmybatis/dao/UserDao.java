package org.kmjs.springbootmybatis.dao;

import org.kmjs.springbootmybatis.model.User;

public interface UserDao {
    public User getUser(int id);
    public int saveUser(User user);
}
