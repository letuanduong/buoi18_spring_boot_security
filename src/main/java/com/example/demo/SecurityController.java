package com.example.demo;


import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SecurityController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String homepage() {
        User user = new User(1L, "user", passwordEncoder.encode("user"));
        userRepository.save(user);
        return "home";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
