package com.app.adi.controller;

import com.app.adi.dto.UserDto;
import com.app.adi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class User {

    private UserService userService;

    @Autowired
    public User(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public int hello() {
        UserDto userDto = new UserDto();
        System.out.println(userDto);
        System.out.println(userService);
        return userDto.age;
    }
}
