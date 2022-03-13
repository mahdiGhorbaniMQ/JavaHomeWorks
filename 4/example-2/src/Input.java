import java.util.Scanner;

public class Input {
    Scanner scanner;

    public Input(){
        scanner = new Scanner(System.in);
    }

    public double getDouble(String message){
        System.out.print(message);
        return scanner.nextDouble();
    }
}
