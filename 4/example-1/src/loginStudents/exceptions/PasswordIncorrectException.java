package loginStudents.exceptions;

public class PasswordIncorrectException extends Exception{
    public PasswordIncorrectException(){
        super();
    }
    public PasswordIncorrectException(String message){
        super(message);
    }
}
