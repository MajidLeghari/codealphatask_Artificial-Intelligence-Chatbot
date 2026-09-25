package com.example.Artificial.Intelligence.Chatbot.Repositories;

import com.example.Artificial.Intelligence.Chatbot.Entity.TrainingExample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingExampleRepository extends JpaRepository<TrainingExample, Long> {
}