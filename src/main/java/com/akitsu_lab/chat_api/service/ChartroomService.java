package com.akitsu_lab.chat_api.service;

import com.akitsu_lab.chat_api.model.Chatroom;
import com.akitsu_lab.chat_api.repository.ChatroomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChartroomService {
    private final ChatroomRepository chatroomRepository;

    public ChartroomService(ChatroomRepository chatroomRepository) {
        this.chatroomRepository = chatroomRepository;
    }

    public List<Chatroom> findAllChatrooms() {
        return chatroomRepository.selectAllChatrooms();
    }

}
