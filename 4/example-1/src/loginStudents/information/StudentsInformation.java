package loginStudents.information;

import loginStudents.exceptions.UsernameAlreadyExistsException;
import loginStudents.exceptions.UsernameNotFoundException;

import loginStudents.model.Student;
import java.util.HashMap;
import java.util.Map;

public class StudentsInformation {
    private Map<Integer, Student> students = new HashMap<>();

    public StudentsInformation(){
        students.put(11110, new Student(
                "mahdi",
                18,
                11110,
                "11110"
        ));
        students.put(11111, new Student(
                "davud",
                18,
                11111,
                "11111"
        ));
        students.put(11112, new Student(
                "simin",
                19,
                11112,
                "11112"
        ));
        students.put(11113, new Student(
                "reza",
                18,
                11113,
                "11113"
        ));
        students.put(11114, new Student(
                "ali",
                19,
                11114,
                "11114"
        ));
    }

    public Student getStudent(int studentNumber) throws UsernameNotFoundException {
        if (students.containsKey(studentNumber))
            return students.get(studentNumber);
        throw new UsernameNotFoundException("Error: test.model.Student Number " + studentNumber + " not found!");
    }

    public Student deleteStudent(int studentNumber) throws UsernameNotFoundException {
        if (students.containsKey(studentNumber))
            return students.remove(studentNumber);
        throw new UsernameNotFoundException("Error: test.model.Student Number " + studentNumber + " not found!");
    }

    public void addStudent(Student student) throws UsernameAlreadyExistsException {
        if (!students.containsKey(student.getStudentNumber()))
            students.put(student.getStudentNumber(),student);
        throw new UsernameAlreadyExistsException(
                "Error: test.model.Student Number "
                + student.getStudentNumber()
                + "already taken!"
        );
    }
}
