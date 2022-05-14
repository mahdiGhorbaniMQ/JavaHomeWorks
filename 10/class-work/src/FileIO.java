import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FileIO {
    public boolean completed = false;
    public Queue<String> lines = new LinkedList<>();
    public void read(String path){
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            Scanner scanner = new Scanner(fileInputStream);
            while (scanner.hasNextLine()){
                lines.add(scanner.nextLine());
            }
            completed = true;
            fileInputStream.close();
            scanner.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            completed = true;
        }
    }
    public void write(String path) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            while (!completed || !lines.isEmpty()){
                System.out.print("");
                while (!lines.isEmpty()){
                    fileWriter.write(lines.remove()+'\n');
                }
            }
            fileWriter.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
