package com.example.Artificial.Intelligence.Chatbot.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "training_example")

public class TrainingExample {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    public String getExampleText() {
        return exampleText;
    }

    public void setExampleText(String exampleText) {
        this.exampleText = exampleText;
    }

    @Column(nullable = false)
    private String exampleText;

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    @ManyToOne
    @JoinColumn(name = "intent_id")
    private Intent intent;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
