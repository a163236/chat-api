package com.akitsu_lab.chat_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/greeting")
    public String greeting (){

        // reference: https://dev.classmethod.jp/articles/use_spring-boot_jdbctemplate/
        // executeはCREATEとかDROPの時に使う
        jdbcTemplate.execute("SELECT * FROM users");

        // SELECT文を使う時はこんな感じ
        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM users");
        list.forEach(System.out::println);
        return "Hello";
    }
}
