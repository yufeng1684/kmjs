package org.kmjs.springcloudserviceprovider.service;

import org.kmjs.springcloudserviceprovider.domain.DomainUser;

public interface UserService {
    public DomainUser getUser(int id);
    public int saveUser(DomainUser user);
}
