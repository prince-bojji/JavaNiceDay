package week1.Exercises.submission.exercise3.grace;

/**
 * Generics
 * 
 * @author Grace
 */

public class Main {

    public static void main(String[] args) {
        CustomCollection<String> a = new CustomCollection<>(4);
        CustomCollection<Integer> b = new CustomCollection<>(5);

        // Add elements
        a.add("HELLO");
        a.add("WORLD");
        a.add("!!!!!!");
        a.add("<><><><>");

        b.add(3);
        b.add(6);
        b.add(5);

        // Get elements
        System.err.println("Before:");
        for (int i = 0; i < a.size; i++) {
            System.out.println(a.get(i));
        }

        for (int i = 0; i < b.size; i++) {
            System.out.println(b.get(i));
        }

        // Remove elements
        a.remove(0);
        a.remove(1);

        b.remove(0);

        System.err.println("After:");
        for (int i = 0; i < a.size; i++) {
            System.out.println(a.get(i));
        }

        for (int i = 0; i < b.size; i++) {
            System.out.println(b.get(i));
        }
    }
}
