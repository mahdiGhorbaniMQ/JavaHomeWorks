import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static boolean hasItem;
    public static int count;

    public static void search(Object[] arr, Object item){
        hasItem = Arrays.asList(arr).contains(item);
        count = Collections.frequency(Arrays.asList(arr),item);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("insert length of array: ");
        int length = scanner.nextInt();
        Object[] array = new Object[length];

        for (int i=0;i<length;i++){
            System.out.print("insert "+(i+1)+"th item: ");
            array[i] = scanner.next();
        }
        Object item;
        System.out.print("insert item that you want search: ");
        item = scanner.next();
        search(array,item);
        if (hasItem){
            System.out.println("count of item is: "+ count);
        }else {
            System.out.println("item is not in your list!");
        }
    }
}
