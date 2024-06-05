package com.app.adi.controller;

import com.app.adi.dto.UserDto;
import com.app.adi.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Country {

    private UserService userService;

    public Country(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/bye")
    public int getAns(){
        UserDto userDto = new UserDto();
        System.out.println(userDto);
        System.out.println(userService);
        return userDto.age;
    }
}
