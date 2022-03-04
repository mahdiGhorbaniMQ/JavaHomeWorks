import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        Number myNumber = new Number(scanner.nextInt());
        System.out.println(myNumber.getNumber()+":");
        System.out.println("is even: " + myNumber.isEven());
        System.out.println("is odd: " + myNumber.isOdd());
        System.out.println("is positive: " + myNumber.isPositive());
        System.out.println("is negative: " + myNumber.isNegative());
        System.out.println("is zero: " + myNumber.isZero());
    }
}
