package week1.exercises.submission.exercise4.jehan;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // First Lists
        List<Integer> l1 = new LinkedList<>();
        System.out.print("Enter length of l1 : ");
        int l1Length = scanner.nextInt();
        System.out.println("Enter " + l1Length + " lists of integers : ");
        for(int i = 0; i < l1Length; i++){
            l1.add(scanner.nextInt());
        }

        // Second Lists
        List<Integer> l2 = new LinkedList<>();
        System.out.print("\nEnter length of l2 : ");
        int l2Length = scanner.nextInt();
        System.out.println("Enter " + l2Length + " lists of integers : ");
        for(int i = 0; i < l2Length; i++){
            l2.add(scanner.nextInt());
        }

        Solution solution = new Solution();
        List<Integer> result = solution.addTwoNumbers(l1, l2);

        System.out.println("\nSum of two numbers:");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i < result.size() - 1) {
                System.out.print(" -> ");
            }
        }
        scanner.close();
    }
}