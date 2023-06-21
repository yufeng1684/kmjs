package org.kmjs.springbootmybatis.service;

import org.kmjs.springbootmybatis.domain.DomainUser;

public interface UserService {
    public DomainUser getUser(int id);
    public int saveUser(DomainUser user);
}
