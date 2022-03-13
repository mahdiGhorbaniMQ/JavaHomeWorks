import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("please enter your text: ");
        MyString myString = new MyString(scanner.nextLine());
        try {
            myString.searchForNumber();
            System.out.println("Length of your text is: "+myString.length());
        }catch (NotValidTextException e){
            System.out.println(e.getMessage());
        }
    }
}
