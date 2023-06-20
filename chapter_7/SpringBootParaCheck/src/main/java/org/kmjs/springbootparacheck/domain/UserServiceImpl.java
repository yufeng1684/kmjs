package org.kmjs.springbootparacheck.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.SortedMap;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository repository;

    @Override
    public void add(User user) {
        repository.save(user);
    }

    @Override
    public List<User> getList() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return repository.findAll(PageRequest.of(0, 10, sort)).getContent();
    }
}
