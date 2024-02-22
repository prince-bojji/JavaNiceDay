package week1.exercises.submission.exercise4.jehan;

import java.util.LinkedList;
import java.util.List;

// Provides a solution for adding two numbers represented by linked lists.
public class Solution {
    public List<Integer> addTwoNumbers(List<Integer> l1, List<Integer> l2) {
        List<Integer> result = new LinkedList<>();
        int carry = 0;
        int i = 0;

        // Traverse both input lists and perform addition
        while (i < l1.size() || i < l2.size() || carry != 0) {
            int num1 = (i < l1.size()) ? l1.get(i) : 0;
            int num2 = (i < l2.size()) ? l2.get(i) : 0;

            int sum = num1 + num2 + carry;

            int num = sum % 10;
            carry = sum / 10;

            // Add the sum to the result list
            result.add(num);

            i++;
        }

        return result;
    }
}
