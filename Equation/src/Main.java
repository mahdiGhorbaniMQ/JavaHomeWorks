import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double a,b,c,d,e,f;
        Scanner scanner = new Scanner(System.in);
        System.out.println("ax + by = e; insert a, b, e");

        System.out.print("a: ");
        a = scanner.nextDouble();

        System.out.print("b: ");
        b = scanner.nextDouble();

        System.out.print("e: ");
        e = scanner.nextDouble();

        System.out.println("cx + dy = f; insert c, e, f");

        System.out.print("c: ");
        c = scanner.nextDouble();

        System.out.print("d: ");
        d = scanner.nextDouble();

        System.out.print("f: ");
        f = scanner.nextDouble();

        if ((a*d)-(b*c) == 0){
            System.out.print("this equations have not any response!");
            return;
        }

        System.out.println("x: " + ((e*d)-(b*f))/((a*d)-(b*c)));
        System.out.println("y: " + ((a*f)-(e*c))/((a*d)-(b*c)));
    }
}
