package com.app.adi.service;

import com.app.adi.interfaces.UserInterface;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class Student implements UserInterface {
    String username;
    String password;

    public Student(){
        System.out.println("Student constructor");
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
