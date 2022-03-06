import java.util.Scanner;

public class Main {

    public static int getOperator(Scanner scanner){
        System.out.println("insert 1 for sum:");
        System.out.println("insert 2 for difference:");
        System.out.println("insert 3 for multiplication:");
        System.out.println("insert 4 for division:");

        int operator = scanner.nextInt();

        return operator>0 && operator<5
                ?operator
                :getOperator(scanner);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("insert first number:");
        float a = scanner.nextInt();
        System.out.println("insert second number:");
        float b = scanner.nextInt();

        int operator = getOperator(scanner);

        switch (operator){
            case 1: {
                System.out.println("result is: "+(a+b));
                break;
            }
            case 2: {
                System.out.println("result is: "+Math.abs(a-b));
                break;
            }
            case 3: {
                System.out.println("result is: "+(a*b));
                break;
            }
            case 4: {
                System.out.println(
                        b!=0
                        ?"result is: "+(a/b)
                        :"second number can't be 0!");
                break;
            }
        }
    }
}
