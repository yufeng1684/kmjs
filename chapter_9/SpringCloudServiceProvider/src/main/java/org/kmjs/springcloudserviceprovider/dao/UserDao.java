package org.kmjs.springcloudserviceprovider.dao;

import org.kmjs.springcloudserviceprovider.model.User;

public interface UserDao {
    public User getUser(int id);
    public int saveUser(User user);
}
