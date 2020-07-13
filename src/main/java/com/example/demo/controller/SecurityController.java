package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.IUserService;
import com.example.demo.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {

    @Autowired
    IUserService iUserService;

    @Autowired
    PasswordEncoder passwordEncoder;

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }


    @GetMapping("/register")
    public ModelAndView registerPage(){
        User user = new User();
        ModelAndView mv = new ModelAndView("register");
        mv.addObject("user", user);
        return mv;
    }

    @PostMapping("/register")
    public String PostRegisterPage(@ModelAttribute(value = "user") User user){
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        iUserService.save(user);
        return "UserRegisterSuccess";
    }


    @GetMapping("/home")
    public String home(){
        return "welcome";
    }

    @PostMapping(value = {"/home"})
    public String Homepage(Model model){
        model.addAttribute("user", getPrincipal());
        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "admin";
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }

    @RequestMapping(value = "/dba", method = RequestMethod.GET)
    public String dbaPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "dba";
    }
}
