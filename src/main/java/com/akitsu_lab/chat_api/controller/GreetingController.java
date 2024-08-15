package com.akitsu_lab.chat_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {

    @Autowired
    private JdbcClient jdbcClient;

    @GetMapping("/greeting")
    public String greeting (){

        // JdbcTemplateじゃなくてJdbcClientを使う方がスマートかも
        jdbcClient.sql("SELECT * FROM users").query().listOfRows().forEach(System.out::println);
        return "Hello";
    }
}
