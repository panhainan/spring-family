package site.sixteen.service;

import site.sixteen.entity.User;

public interface UserService {
    User getByName(String name);
}
