package site.sixteen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.sixteen.dao.UserRepository;
import site.sixteen.entity.User;
import site.sixteen.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public User getByName(String name) {
        return userRepository.findByNameIgnoringCase(name);
    }
}
