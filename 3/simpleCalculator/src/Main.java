import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a,b;
        char operator;
        try {
            System.out.print("Enter first number: ");
            a = scanner.nextDouble();
            System.out.print("Enter operator: ");
            operator = scanner.next().charAt(0);
            System.out.print("Enter second number: ");
            b = scanner.nextDouble();
        }catch (Exception e){
            System.out.println(e);
            return;
        }

        try {
            System.out.println(Calculator.calculate(
                    a,
                    operator,
                    b
            ));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
