package loginStudents.io;

import loginStudents.model.Student;
import java.util.Scanner;

public class Input {
    public final Scanner scanner = new Scanner(System.in);
    private Output output;
    public String getName(){
        System.out.print("Enter your name: ");
        return scanner.next();
    }

    public int getAge(){
        System.out.print("Enter your age: ");
        return scanner.nextInt();
    }

    public int getStudentNumber(){
        System.out.print("Enter your student number: ");
        return scanner.nextInt();
    }

    public String getPassword(){
        System.out.print("Enter password: ");
        return scanner.next();
    }

    public int getMenuItem(){
        output.printMenu();
        int item = scanner.nextInt();
        if (item<5 && item>0) return item;
        else return getMenuItem();
    }

    public Student getStudent(){
        return new Student(
                getName(),
                getAge(),
                getStudentNumber(),
                getPassword()
        );
    }

    public Input(Output output){
        this.output = output;
    }
}
