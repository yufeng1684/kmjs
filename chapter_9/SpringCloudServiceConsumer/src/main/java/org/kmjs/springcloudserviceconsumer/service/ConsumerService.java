package org.kmjs.springcloudserviceconsumer.service;

import org.kmjs.springcloudserviceconsumer.domian.DomainUser;

public interface ConsumerService {
    public DomainUser getUserFromProvider(int id);
    public int saveUserToProvider(DomainUser user);
}
