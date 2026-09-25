package com.example.Artificial.Intelligence.Chatbot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    // Open chatbot at http://localhost:8080/
    @GetMapping("/")
    public String home() {
        return "chat";
    }

    // Open chatbot at http://localhost:8080/chat
    @GetMapping("/chat")
    public String chatPage() {
        return "chat";
    }
}
