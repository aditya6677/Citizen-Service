package com.app.adi.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public int ans = 0;

    public UserService(){
        ans += 1;
    }

    public String getUsername(){
        return "aditya76";
    }
}
