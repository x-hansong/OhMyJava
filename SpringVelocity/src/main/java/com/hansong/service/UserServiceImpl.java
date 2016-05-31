package com.hansong.service;

import com.hansong.mapper.UserMapper;
import com.hansong.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xhans on 2016/5/30 0030.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    public User getUser(int uid) {
        return userMapper.get(uid);
    }

    public User addUser(User user) {
        userMapper.add(user);
        return user;
    }

    public User updateUser(User user) {
        userMapper.update(user);
        return user;
    }

    public User deleteUser(int uid) {
        User user = userMapper.get(uid);
        userMapper.delete(uid);
        return user;
    }
}
