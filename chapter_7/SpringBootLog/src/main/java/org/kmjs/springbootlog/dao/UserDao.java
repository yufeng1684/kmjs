package org.kmjs.springbootlog.dao;

import org.kmjs.springbootlog.model.User;

public interface UserDao {
    public User getUser(int id);
    public int saveUser(User user);
}
