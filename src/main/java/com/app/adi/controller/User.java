package com.app.adi.controller;

import com.app.adi.Entity.UserEntity;
import com.app.adi.dto.UserDto;
import com.app.adi.interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class User {

    private UserInterface service;
    private JdbcTemplate jdbcTemplate;
    private JdbcClient jdbcClient;

    @Autowired
    public User(UserInterface service, JdbcTemplate jdbcTemplate, JdbcClient jdbcClient) {
        this.service = service;
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcClient = jdbcClient;
    }

    @GetMapping("/hello")
    public int hello() {
        int ans = jdbcTemplate.update("insert into users(id, username) values (?,?)", Math.random(), "aditya");
        List<UserEntity> list = jdbcClient.sql("select * from users").query(UserEntity.class).list();
        list.forEach(userEntity -> System.out.println(userEntity.getId() + " " + userEntity.getUsername()));
        return list.size();
    }
}
