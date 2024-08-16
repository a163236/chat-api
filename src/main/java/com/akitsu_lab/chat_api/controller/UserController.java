package com.akitsu_lab.chat_api.controller;

import com.akitsu_lab.chat_api.model.User;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/user")
@RestController
public class UserController {

    private final JdbcClient jdbcClient;

    public UserController(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @PostMapping()
    public void createUser(@RequestBody User user) {
        jdbcClient.sql("INSERT INTO users(user_name, password) VALUES(?, ?)")
                .params(user.userName())
                .params(user.password())
                .update();
    }

    @DeleteMapping()
    public void deleteUser(@RequestParam String name) {
        jdbcClient.sql("DELETE FROM users WHERE user_name=?")
                .params(name)
                .update();
    }
}

