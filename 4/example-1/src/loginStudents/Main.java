package loginStudents;

import loginStudents.controllers.Login;
import loginStudents.controllers.Update;
import loginStudents.exceptions.PasswordIncorrectException;
import loginStudents.exceptions.UsernameNotFoundException;
import loginStudents.informations.Authentication;
import loginStudents.informations.StudentsInformation;
import loginStudents.io.Input;
import loginStudents.io.Output;

public class Main {
    public static void main(String[] args) {
        Output output = new Output();
        Input input = new Input(output);
        StudentsInformation information = new StudentsInformation();
        Login login = new Login(information);
        Update update = new Update(input, information);

        for (;;){
            while (!Authentication.isAuthentication){
                try {
                    login.loginStudent(
                            input.getStudentNumber(),
                            input.getPassword()
                    );
                    output.printStudentInfo(Authentication.studentInfo);
                } catch (UsernameNotFoundException | PasswordIncorrectException e) {
                    System.out.println("Error: Username and password is not matched!");
                }
            }
            switch (input.getMenuItem()){
                case 1:{
                    output.printStudentInfo(Authentication.studentInfo);
                    break;
                }
                case 2:{
                    update.updateStudent();
                    break;
                }
                case 3:{
                    try {
                        information.deleteStudent(Authentication.studentInfo.getStudentNumber());
                        login.logoutStudent();
                    } catch (UsernameNotFoundException ignored) {}
                    break;
                }
                default:{
                    login.logoutStudent();
                    break;
                }
            }
        }

    }
}
