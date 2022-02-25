import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double x,y;
        Scanner scanner = new Scanner(System.in);
        System.out.print("insert x: ");
        x = scanner.nextDouble();
        System.out.print("insert y: ");
        y = scanner.nextDouble();

        System.out.println("Area is: "+ x*y);
        System.out.println("Perimeter is: "+ (x+y)*2);
    }
}
