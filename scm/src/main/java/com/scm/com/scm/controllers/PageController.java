package com.scm.com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;

@Controller
public class PageController {
    
    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("Home page handler");
        model.addAttribute("name", "Substring Technology");
        model.addAttribute("Youtube", "Learn code");
        model.addAttribute("link","https://www.youtube.com/watch?v=dQw4w-pfA&ab_");
        
        return "homee";
    }
    
}
