package com.company;

import java.util.List;

public class Student {
    private String name;
    private String fatherName;
    private List<Float> scores;

    public void print(){
        System.out.println("Name: " + name);
        System.out.println("FatherName: " + fatherName);
        System.out.println("Scores: ");
        scores.forEach(System.out::println);
    }

    public Student(){}
    public Student(String name, String fatherName, List<Float> scores){
        this.name = name;
        this.fatherName = fatherName;
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public List<Float> getScores() {
        return scores;
    }

    public void setScores(List<Float> scores) {
        this.scores = scores;
    }
}
