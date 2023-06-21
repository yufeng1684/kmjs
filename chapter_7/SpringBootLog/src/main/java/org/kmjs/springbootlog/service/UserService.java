package org.kmjs.springbootlog.service;

import org.kmjs.springbootlog.domain.DomainUser;

public interface UserService {
    public DomainUser getUser(int id);
    public int saveUser(DomainUser user);
}
