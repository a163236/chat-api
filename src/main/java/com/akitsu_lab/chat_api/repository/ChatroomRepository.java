package com.akitsu_lab.chat_api.repository;

import com.akitsu_lab.chat_api.model.Chatroom;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChatroomRepository {
    private final JdbcClient jdbcClient;

    public ChatroomRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Chatroom> selectAllChatrooms() {
        return jdbcClient.sql("SELECT * FROM chatrooms")
                .query()
                .listOfRows()
                .stream()
                .map(row -> new Chatroom((int) row.get("room_id"), (String) row.get("room_name")))
                .toList();

    }

}
