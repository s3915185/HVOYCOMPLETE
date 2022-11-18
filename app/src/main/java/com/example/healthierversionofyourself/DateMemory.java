package com.example.healthierversionofyourself;

public class DateMemory {
    private String date;
    private int score;
    private Integer id;
    private int day, month, year;
    private int foodScore, lifestyleScore, knowledgeScore;

    public int getFoodScore() {
        return foodScore;
    }

    public int getLifestyleScore() {
        return lifestyleScore;
    }

    public int getKnowledgeScore() {
        return knowledgeScore;
    }

    public DateMemory(String date, int score, Integer id, int lifestyleScore, int knowledgeScore, int foodScore) {
        this.date = date;
        this.score = score;
        this.id = id;
        this.foodScore = foodScore;
        this.lifestyleScore = lifestyleScore;
        this.knowledgeScore = knowledgeScore;
        String[] parts = date.split("/", 3);
        this.day = Integer.parseInt(parts[0]);
        this.month = Integer.parseInt(parts[1]);
        this.year = Integer.parseInt(parts[2]);
    }

    public String getDate() {
        return date;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
