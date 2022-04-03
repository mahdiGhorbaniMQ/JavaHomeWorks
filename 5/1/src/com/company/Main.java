package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static String getStudentNumber(Scanner scanner) throws EndGettingInfoException {
        System.out.println("Enter your studentNumber to insert your info,");
        System.out.println("Enter /end to stop it: ");
        String input = scanner.next();
        if (input.equals("/end")) throw new EndGettingInfoException();
        return input;
    }
    public static Student getStudentInfo(Scanner scanner) {
        Student student = new Student();

        System.out.print("Enter your name: ");
        student.setName(scanner.next());

        System.out.print("Enter your average: ");
        student.setAverage(scanner.nextFloat());

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
                }else {
                    System.out.println("This studentNumber is already taken!");
                }
            }catch (EndGettingInfoException e){
                end = true;
            }
        }

        System.out.print("Enter your studentNumber to show your info: ");
        String studentNumber = scanner.next();
        if (students.containsKey(studentNumber)){
            System.out.println("Name: " + students.get(studentNumber).getName());
            System.out.println("Average: " + students.get(studentNumber).getAverage());
        }
        else System.out.println("Student not found!");
    }
}
