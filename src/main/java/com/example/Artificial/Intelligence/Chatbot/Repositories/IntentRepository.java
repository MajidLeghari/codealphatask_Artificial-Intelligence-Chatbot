package com.example.Artificial.Intelligence.Chatbot.Repositories;

import com.example.Artificial.Intelligence.Chatbot.Entity.Intent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntentRepository extends JpaRepository<Intent, Long> {
}