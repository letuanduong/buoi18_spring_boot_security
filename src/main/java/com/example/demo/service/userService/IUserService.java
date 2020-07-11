package com.example.demo.service.userService;


import com.example.demo.model.User;

public interface IUserService {

    User getUserByUsername(String username);

    User getCurrentUser();
}
