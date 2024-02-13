package week1.Collections;

import java.util.ArrayList;
import java.util.List;

public class UsingArrayList {
    public static void main(String[] args) {
        // Creating an ArrayList of Strings
        List<String> list = new ArrayList<>();

        // Adding elements to the list
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        // Iterating through the list
        for (String fruit : list) {
            System.out.println(fruit);
        }
    }
}

