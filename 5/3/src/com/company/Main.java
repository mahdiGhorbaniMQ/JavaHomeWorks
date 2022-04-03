package com.company;

import java.util.*;

public class Main {

    public static String getStudentNumber(Scanner scanner) throws Exception {
        System.out.println("Enter your student number or /end: ");
        String studentNumber = scanner.next();
        if (studentNumber.equals("/end")) throw new Exception();
        return studentNumber;
    }

    public static List<Float> getScores(Scanner scanner){
        List<Float> scores = new ArrayList<>();
        for (int i=0; i<5; i++){
            System.out.print((i+1) + ": ");
            try {
                scores.add(scanner.nextFloat());
            }catch (Exception e){
                System.out.println("score should be number!");
                i--;
            }
        }
        return scores;
    }

    public static Student getStudentInfo(Scanner scanner){
        Student student = new Student();
        System.out.print("Enter your name: ");
        student.setName(scanner.next());
        System.out.print("Enter your fatherName: ");
        student.setFatherName(scanner.next());
        System.out.println("Enter your scores: ");
        student.setScores(getScores(scanner));
        return student;
    }

    public static void main(String[] args) {
        Map<String, Student> students = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        boolean end = false;

        while (!end){
            try {
                String studentNumber = getStudentNumber(scanner);
                if (!students.containsKey(studentNumber)){
                    students.put(studentNumber, getStudentInfo(scanner));
                }else System.out.println("This StudentNumber already taken!");
            }catch (Exception e){
                end = true;
            }
        }

        System.out.print("Enter your StudentNumber: ");
        String studentNumber = scanner.next();
        if (students.containsKey(studentNumber)){
            Student student = students.get(studentNumber);
            student.print();
        }
        else System.out.println("Student not found!");
    }
}
