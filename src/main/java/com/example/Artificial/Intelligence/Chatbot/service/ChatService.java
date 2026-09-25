package com.example.Artificial.Intelligence.Chatbot.service;

import com.example.Artificial.Intelligence.Chatbot.Entity.Intent;
import com.example.Artificial.Intelligence.Chatbot.dto.ChatResponse;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private final NLPService nlpService;

    public ChatService(NLPService nlpService) {
        this.nlpService = nlpService;
    }

    public ChatResponse processMessage(String message) {

        Intent intent = nlpService.findIntent(message);

        if (intent == null) {

            return new ChatResponse(
                    "UNKNOWN",
                    "Sorry, I don't understand your question."
            );
        }

        return new ChatResponse(
                intent.getName(),
                intent.getResponse()
        );
    }
}
