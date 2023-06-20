package org.kmjs.springbootjpa.domain;

import java.util.List;

public interface UserService {
    public void add(User user);
    public List<User> getList();
}
