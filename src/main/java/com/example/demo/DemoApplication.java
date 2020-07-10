package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void initUsers(){
        List<User> users = Stream.of(
                new User(101, "user1", "pw1", "user1@gmail"),
                new User(102, "user2", "pw2", "user2@gmail"),
                new User(101, "user3", "pw3", "user3@gmail"),
                new User(102, "user4", "pw4", "user4@gmail")
        ).collect(Collectors.toList());
        userRepository.saveAll(users);
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
