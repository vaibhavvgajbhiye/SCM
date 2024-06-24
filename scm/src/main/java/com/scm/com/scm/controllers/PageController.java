package com.scm.com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.com.scm.entities.User;
import com.scm.com.scm.forms.UserForm;
import com.scm.com.scm.helpers.Message;
import com.scm.com.scm.helpers.MessageType;
import com.scm.com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMethod;

//CONTROLLER CLASS HOTI HAI,USKE ANDAR JO METHODS HOTI HAI VO HANDLER
//INN ROUTE KO HANDLE KAR RAHA HAI
//JAISE HUM HOMEE FIRE KAR RAHE HAI,ROUTE HANDLE HO RHA HAI
//JO SIMPLY HUME VIEW THROW KAR RAHA HAI
//AUR VO VIEW HUME WEBSITE PR DIKH RHA HAI "HOMEE"PAGE
@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "redirect:/homee";
    }
    
    
    @RequestMapping("/homee")
    public String home(Model model) {
        System.out.println("Home page handler");
        model.addAttribute("name", "Substring Technology");
        model.addAttribute("Youtube", "Learn code");
        model.addAttribute("link","https://www.youtube.com/watch?v=dQw4w-pfA&ab_");
        
        return "homee";
    }
    
    // about route

    @RequestMapping("/about")
    public String aboutPage(Model model){
        model.addAttribute("isLogin",true);
        System.out.println("About page loading");
        return "about";
    }


    //services

    @RequestMapping("/services")
    public String servicesPage(){
        System.out.println("Services page loading");
        return "services";
    }

    //contact page

    @GetMapping("/contact")
    public String contact() {
        System.out.println("Contact loading");
        return new String("contact");
    }

    @GetMapping("/login")
    public String login() {
        System.out.println("Login page loading");
        return new String("login");
    }

    @GetMapping("/register")
    public String register(Model model) {
        UserForm userForm=new UserForm();
        //default data bhi daal sakte hai
        // userForm.setName("vaibhav");

        model.addAttribute("userForm", userForm);

        System.out.println("SignUp page loading");
        return new String("register");
    }
    
    //processing register
    
    @RequestMapping(value = "/do-register", method=RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult, HttpSession session) {
        System.out.println("Processing registration");
        //fetch form data
        //UserForm
        System.out.println(userForm);

        //validate form data
        if(rBindingResult.hasErrors()){
            return "register";
        }

        //save to database
        
        //userService

        //UserForm-->User
        // User user=User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .profilePic("https://wallpapers.com/images/hd/blank-default-pfp-wue0zko1dfxs9z2c.jpg")
        // .build();

        User user=new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("https://wallpapers.com/images/hd/blank-default-pfp-wue0zko1dfxs9z2c.jpg");

        User savedUser=userService.saveUser(user);
        System.out.println("User saved");

        //message = "Registration successful"

        //add the message:
        Message message=Message.builder().content("Registration Successful").type(MessageType.blue).build();
        session.setAttribute("message", message);


        //redirect to login page
        return "redirect:/register";
    }
    
}
