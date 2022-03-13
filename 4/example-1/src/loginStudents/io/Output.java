package loginStudents.io;

import loginStudents.model.Student;

public class Output {

    public void printStudentInfo(Student student){
        System.out.println();
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("Student Number: " + student.getStudentNumber());
    }
    public void printMenu(){
        System.out.println();
        System.out.println("To see your account info enter: 1");
        System.out.println("To updating your account info enter: 2");
        System.out.println("To deleting your account enter: 3");
        System.out.println("To logout enter: 4");
        System.out.println();
    }
    public Output(){}
}
