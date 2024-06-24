package com.scm.com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
public class UserController {
    
    //user dashboard page

    @RequestMapping(value = "/dashboard")
    public String userDashboard() {
        System.out.println("User Dashboard");
        return "user/dashboard";
    }
    
    //user profile page

    @RequestMapping(value = "/profile")
    public String userProfile() {
        System.out.println("User Profile");
        return "user/profile";
    }

    //user add contacts page

    //user view contacts

    //user edit contact

    //user delete contact

    //user seaarch contact
}
