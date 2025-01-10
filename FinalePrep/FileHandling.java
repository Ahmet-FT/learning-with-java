import java.io.File;
import java.util.*;

public class FileHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File("test.txt");

        if (file.exists()) {
            System.out.println("File exists.");
            System.out.println(file.getAbsolutePath());

        } else {
            System.out.println("File does not exist.");
        }


        scanner.close();


    }
}