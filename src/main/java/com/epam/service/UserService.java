package com.epam.service;

import com.epam.model.User;

public interface UserService {

    User findByUserNameAndPassword(String userName,String password);
}
