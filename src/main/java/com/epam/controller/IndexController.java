package com.epam.controller;

import com.epam.model.User;
import com.epam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest httpRequest, HttpSession httpSession) {

        String username = httpRequest.getParameter("userName");
        String password = httpRequest.getParameter("password");
        User user = userService.findByUserNameAndPassword(username, password);
        if (user != null) {
            httpSession.setAttribute("user",user);
            return "redirect:/product";
        }
        return "login";
    }

}
