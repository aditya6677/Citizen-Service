package com.app.adi.dto;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class UserDto {
    private String username;
    private String password;
    public int age = 25;

    public UserDto() {
        age += 1;
    }
}
