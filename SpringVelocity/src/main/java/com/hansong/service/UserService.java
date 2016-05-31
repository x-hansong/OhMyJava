package com.hansong.service;

import com.hansong.model.User;

/**
 * Created by xhans on 2016/5/30 0030.
 */
public interface UserService {
    User getUser(int uid);
    User addUser(User user);
    User updateUser(User user);
    User deleteUser(int uid);
}
