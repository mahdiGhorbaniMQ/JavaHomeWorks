import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("insert length of array:");
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        Integer[] numbers = new Integer[length];
        for (int i=0; i<length; i++){
            System.out.println("insert "+(i+1)+"th number:");
            numbers[i] = (scanner.nextInt());
        }
        System.out.print("the maximum number is: "+ Collections.max(Arrays.asList(numbers)));
    }
}
