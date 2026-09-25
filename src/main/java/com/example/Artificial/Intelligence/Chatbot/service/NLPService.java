package com.example.Artificial.Intelligence.Chatbot.service;

import com.example.Artificial.Intelligence.Chatbot.Entity.Intent;
import com.example.Artificial.Intelligence.Chatbot.Entity.TrainingExample;
import com.example.Artificial.Intelligence.Chatbot.Repositories.TrainingExampleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NLPService {
    private final TrainingExampleRepository trainingExampleRepository;

    public NLPService(TrainingExampleRepository trainingExampleRepository) {
        this.trainingExampleRepository = trainingExampleRepository;
    }

    public Intent findIntent(String message) {

        String input = normalize(message);

        List<TrainingExample> examples =
                trainingExampleRepository.findAll();

        Intent bestIntent = null;
        int highestScore = 0;

        for (TrainingExample example : examples) {

            String trainingText =
                    normalize(example.getExampleText());

            int score = calculateScore(input, trainingText);

            if (score > highestScore) {
                highestScore = score;
                bestIntent = example.getIntent();
            }
        }

        return bestIntent;
    }

    private String normalize(String text) {

        return text
                .toLowerCase()
                .replaceAll("[^a-zA-Z0-9 ]", "")
                .trim();
    }

    private int calculateScore(String input, String trainingText) {

        String[] inputWords = input.split("\\s+");
        String[] trainingWords = trainingText.split("\\s+");

        int score = 0;

        for (String inputWord : inputWords) {

            for (String trainingWord : trainingWords) {

                if (inputWord.equals(trainingWord)) {
                    score++;
                }
            }
        }

        return score;

}}
