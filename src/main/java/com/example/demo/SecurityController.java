package com.example.demo;

import com.example.demo.entity.AuthRequest;
import com.example.demo.until.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class SecurityController {


//    @Autowired
//    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;


    @RequestMapping("/")
    public String home() {
        return "Welcome home!";
    }

//    @PostMapping("/authenticate")
//    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
//        try{
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
//            );
//                    } catch (Exception ex) {
//            throw new Exception("invalid username/password");
//        }
//        return jwtUtil.generateToken(authRequest.getUsername())
//    }

}
