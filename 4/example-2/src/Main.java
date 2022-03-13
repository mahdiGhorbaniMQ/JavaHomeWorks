import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Input input = new Input();
        System.out.println("a(X^2) + bX + c = 0");
        Equation equation = new Equation(
                input.getDouble("Enter a: "),
                input.getDouble("Enter b: "),
                input.getDouble("Enter c: ")
        );
        try {
            equation.calculate();
            if (equation.getAlfa() == equation.getBeta()){
                System.out.println("This equation just have one root: " + equation.getAlfa());
            }
            else {
                System.out.println("Alfa: " + equation.getAlfa());
                System.out.println("Beta: " + equation.getBeta());
            }
        }catch (NoRootsException | DivisionByZeroException e){
            System.out.println(e.getMessage());
        }
    }
}
