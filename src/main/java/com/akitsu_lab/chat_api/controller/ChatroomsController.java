package com.akitsu_lab.chat_api.controller;

import com.akitsu_lab.chat_api.model.Chatroom;
import com.akitsu_lab.chat_api.service.ChartroomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/chatrooms")
@RestController
public class ChatroomsController {

    private final ChartroomService chartroomService;

    public ChatroomsController(ChartroomService chartroomService) {
        this.chartroomService = chartroomService;
    }

    @GetMapping()
    public List<Chatroom> getAllChatrooms() {
        return chartroomService.findAllChatrooms();
    }
}

