package com.akitsu_lab.chat_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatroomsController {

    @Autowired
    private JdbcClient jdbcClient;

    @GetMapping("/chatrooms")
    public String getChatrooms() {
        jdbcClient.sql("SELECT * FROM chatrooms").query().listOfRows().forEach(System.out::println);
        return "chatrooms";
    }
}
