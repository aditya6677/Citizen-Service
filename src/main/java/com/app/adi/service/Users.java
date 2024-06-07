package com.app.adi.service;

import com.app.adi.interfaces.UserInterface;
import org.springframework.stereotype.Service;

@Service
public class Users implements UserInterface {

    public int ans = 0;

    public Users(){
        ans += 1;
        System.out.println("Users created");
    }

    public String getUsername(){
        return "aditya76";
    }

    @Override
    public String getUserName() {
        return "";
    }

    @Override
    public String getPassword() {
        return "";
    }
}
