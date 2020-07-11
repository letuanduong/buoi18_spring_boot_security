package com.example.demo.config;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class WebSecurity {

    @Autowired
    private UserRepository UserRepository;

    public boolean checkUserId(Authentication authentication, String id) {
        String name = authentication.getName();
        User result = UserRepository.findByUsername(name);
        return result != null && result.getId().toString().equals(id);
    }
}
