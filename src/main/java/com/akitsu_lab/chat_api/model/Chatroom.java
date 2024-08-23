package com.akitsu_lab.chat_api.model;

import java.sql.Timestamp;

public record Chatroom(int roomId, String roomName, Timestamp createdAt) {
}
