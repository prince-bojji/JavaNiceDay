package week1.exercises.submission.exercise4.grace;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Collections - LinkedList
 * 
 * @author Grace
 */
public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> coll1 = new LinkedList<>();
        LinkedList<Integer> coll2 = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        // Get input for collection 1
        getInput(1, scanner, coll1);

        // Get input for collection 2
        getInput(2, scanner, coll2);

        // Reverse the order of the LinkedList elements
        Collections.reverse(coll1);
        Collections.reverse(coll2);

        // Convert the LinkedList to integer
        int intColl1 = convertToInt(coll1);
        int intColl2 = convertToInt(coll2);

        // Add together the reverse of each collection
        int sum = intColl1 + intColl2;

        System.out.println("Sum: " + sum);

        scanner.close();
    }

    public static void getInput(int collNumber, Scanner scanner, LinkedList<Integer> collection) {
        // Get input, string format
        System.out.print("Collection " + collNumber + ": ");
        String str = scanner.nextLine();

        if (checkStr(str, collection) == false) {
            collection.clear();
            getInput(collNumber, scanner, collection);
            return;
        }
    }

    public static boolean checkStr(String value, LinkedList<Integer> collection) {
        // Split string
        String[] strArr = value.split(" ");

        // Convert string to integer, then add int to the list
        int digit;
        for (String x : strArr) {
            digit = Integer.parseInt(x);
            if (0 <= digit && digit <= 9) {
                collection.add(digit);
            } else
                return false;
        }
        return true;
    }

    public static int convertToInt(LinkedList<Integer> collection) {
        // Convert LinkedList to string, then to integer
        StringBuilder buildStr = new StringBuilder();
        for (int i = 0; i < collection.size(); i++) {
            buildStr.append(collection.get(i));
        }

        int intColl = Integer.parseInt(buildStr.toString());

        return intColl;
    }
}
