package loginStudents.controllers;

import loginStudents.informations.Authentication;
import loginStudents.informations.StudentsInformation;
import loginStudents.model.Student;
import loginStudents.exceptions.PasswordIncorrectException;
import loginStudents.exceptions.UsernameNotFoundException;

public class Login {

    private StudentsInformation information;

    public Login(StudentsInformation studentsInformation){
        this.information = studentsInformation;
    }

    public void loginStudent(int studentNumber, String password)
            throws UsernameNotFoundException, PasswordIncorrectException {

        Student studentInfo = information.getStudent(studentNumber);
        if (studentInfo.getPassword().equals(password)) {
            Authentication.studentInfo = studentInfo;
            Authentication.isAuthentication = true;
            return;
        }
        throw new PasswordIncorrectException("Error: Username and password is not matched!");
    }

    public void logoutStudent(){
        Authentication.studentInfo = null;
        Authentication.isAuthentication = false;
    }
}
