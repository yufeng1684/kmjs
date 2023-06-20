package org.kmjs.springbootparacheck.domain;

import java.util.List;

public interface UserService {
    public void add(User user);
    public List<User> getList();
}
