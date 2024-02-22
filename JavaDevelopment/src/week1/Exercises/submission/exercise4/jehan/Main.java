package week1.exercises.submission.exercise4.jehan;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // First List
        List<Integer> l1 = new LinkedList<>();
        l1.add(2);
        l1.add(4);
        l1.add(3);

        // Second List
        List<Integer> l2 = new LinkedList<>();
        l2.add(5);
        l2.add(6);
        l2.add(4);

        Solution solution = new Solution();
        List<Integer> result = solution.addTwoNumbers(l1, l2);

        System.out.println("Sum of two numbers:");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i < result.size() - 1) {
                System.out.print(" -> ");
            }
        }
    }
}