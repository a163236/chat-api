package com.akitsu_lab.chat_api.controller;

import com.akitsu_lab.chat_api.model.Chatroom;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RequestMapping("/chatrooms")
@RestController
public class ChatroomsController {

    private final JdbcClient jdbcClient;

    public ChatroomsController(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @GetMapping()
    public List<Chatroom> getChatrooms() {
        return jdbcClient.sql("SELECT * FROM chatrooms")
                .query()
                .listOfRows()
                .stream()
                .map(row -> new Chatroom((int) row.get("room_id"), (String) row.get("room_name"), (Timestamp) row.get("created_at"))).toList();
    }
}

