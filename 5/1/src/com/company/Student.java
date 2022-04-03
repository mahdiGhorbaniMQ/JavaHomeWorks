package com.company;

public class Student {
    private String name;
    private float average;

    public Student(){}
    public Student(String name, float average){
        this.name = name;
        this.average = average;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }
}
