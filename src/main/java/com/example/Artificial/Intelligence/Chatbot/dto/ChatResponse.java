package com.example.Artificial.Intelligence.Chatbot.dto;

public class ChatResponse {


    private String intent;
    private String response;

    public ChatResponse(String intent, String response) {
        this.intent = intent;
        this.response = response;
    }

    public String getIntent() {
        return intent;
    }

    public String getResponse() {
        return response;
    }
}
