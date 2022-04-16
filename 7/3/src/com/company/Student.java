package com.company;

public class Student {
    private int student_code;
    private String name;
    private int entering_year;
    private float average;
    public Student(){}

    public Student(
            String name,
            int entering_year,
            float average
    ){
        this.name = name;
        this.entering_year = entering_year;
        this.average = average;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public int getStudent_code() {
        return student_code;
    }

    public Student setStudent_code(int student_code) {
        this.student_code = student_code;
        return this;
    }

    public int getEntering_year() {
        return entering_year;
    }

    public Student setEntering_year(int entering_year) {
        this.entering_year = entering_year;
        return this;
    }

    public float getAverage() {
        return average;
    }

    public Student setAverage(float average) {
        this.average = average;
        return this;
    }

    @Override
    public String toString() {
        return
                "student_code: " + student_code + '\n' +
                "name: " + name + '\n' +
                "entering_year" + entering_year + '\n' +
                "average: " + average + '\n';
    }
}
