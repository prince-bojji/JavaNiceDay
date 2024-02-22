package week1.Collections;

import java.util.HashSet;
import java.util.Set;

public class UsingHashSet {
    public static void main(String[] args) {
        // Creating a HashSet of Strings
        Set<String> set = new HashSet<>();

        // Adding elements to the set
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");
        set.add("Banana"); // Adding a duplicate element

        // Printing the elements of the set
        System.out.println("Elements of the set:");
        for (String element : set) {
            System.out.println(element);
        }

        // Checking if an element exists in the set
        String searchElement = "Banana";
        if (set.contains(searchElement)) {
            System.out.println(searchElement + " is present in the set.");
        } else {
            System.out.println(searchElement + " is not present in the set.");
        }

        // Removing an element from the set
        set.remove("Orange");

        // Printing the elements of the set after removal
        System.out.println("Elements of the set after removal:");
        for (String element : set) {
            System.out.println(element);
        }

        // Checking the size of the set
        System.out.println("Size of the set: " + set.size());

        // Clearing the set
        set.clear();

        // Checking if the set is empty
        if (set.isEmpty()) {
            System.out.println("Set is empty.");
        } else {
            System.out.println("Set is not empty.");
        }
    }
}
