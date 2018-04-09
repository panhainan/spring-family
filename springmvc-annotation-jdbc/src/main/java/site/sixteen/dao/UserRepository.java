package site.sixteen.dao;

import site.sixteen.entity.User;

public interface UserRepository {

    void saveUser(User user);

    User getUser(long id);
}
