package main.com.em.service.impl;

import main.com.em.dao.UserMapper;
import main.com.em.domain.User;
import main.com.em.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Admiral on 2018/1/19.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserById(String id) throws Exception {
        return userMapper.findUserById(id);
    }

    @Override
    public void addNewUser(User user) throws Exception {
        userMapper.addNewUser(user);
    }
}
