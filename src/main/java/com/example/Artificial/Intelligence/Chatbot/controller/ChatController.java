package com.example.Artificial.Intelligence.Chatbot.controller;

import com.example.Artificial.Intelligence.Chatbot.dto.ChatRequest;
import com.example.Artificial.Intelligence.Chatbot.dto.ChatResponse;
import com.example.Artificial.Intelligence.Chatbot.service.ChatService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ChatResponse chat(
            @RequestBody ChatRequest request) {

        return chatService.processMessage(
                request.getMessage()
        );
    }
}
