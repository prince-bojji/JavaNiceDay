package week1.Collections;

import java.util.HashMap;
import java.util.Map;

public class UsingHashMap {
    public static void main(String[] args) {
        // Creating a HashMap with Integer keys and String values
        Map<Integer, String> map = new HashMap<>();

        // Adding key-value pairs to the map
        map.put(1, "John");
        map.put(2, "Alice");
        map.put(3, "Bob");

        // Accessing values using keys
        System.out.println("Name associated with key 1: " + map.get(1));

        // Iterating through the map
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
