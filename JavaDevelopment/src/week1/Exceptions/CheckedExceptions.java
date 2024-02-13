package week1.Exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptions {
    public static void main(String [] args) {
        try {
            // Code that might throw a checked exception
            BufferedReader br = new BufferedReader(new FileReader("file.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            // Handle the IOException
            System.out.println("An error occurred while reading the file.");
        }
    }
}
