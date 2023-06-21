package org.kmjs.springbootmybatis.service.impl;

import org.kmjs.springbootmybatis.dao.UserDao;
import org.kmjs.springbootmybatis.domain.DomainUser;
import org.kmjs.springbootmybatis.model.User;
import org.kmjs.springbootmybatis.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public DomainUser getUser(int id) {
        User user = userDao.getUser(id);
        if(user!=null) {
            DomainUser domainUser = new DomainUser();
            BeanUtils.copyProperties(user, domainUser);
            return domainUser;
        }
        return null;
    }

    @Override
    public int saveUser(DomainUser domainUser) {
        User user = new User();
        BeanUtils.copyProperties(domainUser, user);
        return userDao.saveUser(user);
    }
}
