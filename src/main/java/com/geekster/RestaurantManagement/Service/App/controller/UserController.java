package com.geekster.RestaurantManagement.Service.App.controller;

import com.geekster.RestaurantManagement.Service.App.dto.SignInInput;
import com.geekster.RestaurantManagement.Service.App.dto.SignInOutput;
import com.geekster.RestaurantManagement.Service.App.dto.SignUpInput;
import com.geekster.RestaurantManagement.Service.App.dto.SignUpOutput;
import com.geekster.RestaurantManagement.Service.App.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    //sign up
    @PostMapping("/signup")
    public SignUpOutput signUp(@RequestBody SignUpInput signUpDto){
        return userService.singUp(signUpDto);
    }

    //SingIn
    @PostMapping("/signing")
    public SignInOutput signup(@RequestBody SignInInput signInInDto){
        return  userService.signIn(signInInDto);
    }
}
