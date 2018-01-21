package main.com.em.dao;

import main.com.em.domain.User;

/**
 * Created by Admiral on 2018/1/19.
 */
public interface UserMapper {
    public User findUserById(String id);

    public void addNewUser(User user);
}
