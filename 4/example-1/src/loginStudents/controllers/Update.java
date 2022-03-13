package loginStudents.controllers;

import loginStudents.informations.Authentication;
import loginStudents.informations.StudentsInformation;
import loginStudents.io.Input;
import loginStudents.model.Student;
import loginStudents.exceptions.UsernameNotFoundException;

public class Update {
    private Input input;

    private StudentsInformation information;

    public void updateStudent(){
        try {
            Student student = information.getStudent(Authentication.studentInfo.getStudentNumber());
            student.setName(input.getName());
            student.setAge(input.getAge());
            student.setPassword(input.getPassword());
        } catch (UsernameNotFoundException ignored) {}
    }

    public Update(Input input, StudentsInformation information){
        this.input = input;
        this.information = information;
    }
}
