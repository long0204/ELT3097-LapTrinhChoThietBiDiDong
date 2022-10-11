package com.example.geoquiz;

public class Question {
    private final String questionText;
    private final Boolean questionAnswer;

    public Question(String questionText, Boolean questionAnswer) {
        this.questionText = questionText;
        this.questionAnswer = questionAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public Boolean getQuestionAnswer() {
        return questionAnswer;
    }
}