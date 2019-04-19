package com.epam.controller;

import com.epam.model.User;
import com.epam.service.UserService;
import com.epam.uitl.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/user/")
public class UserRegistration {
    @Autowired
    UserService userService;

    @RequestMapping(value = "saveUser", method = RequestMethod.POST)
    public ResponseData userRegistration(@RequestBody User user) {
        if (userService.saveUser(user)) {
            return new ResponseData("saved user", "", user);
        }
        return new ResponseData("failed", "", null);
    }
}
