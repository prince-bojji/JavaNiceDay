package week1.exercises.submission.exercise4.jehan;

// Provides a solution for adding two numbers represented by linked lists.
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tail = head; 
        int carry = 0; 

        // Traverse both input lists and perform addition
        while (l1 != null || l2 != null || carry != 0) {
            int num1 = (l1 != null) ? l1.value : 0;
            int num2 = (l2 != null) ? l2.value : 0;

            int sum = num1 + num2 + carry;

            int num = sum % 10;
            carry = sum / 10;

            // Create a new node with the num and append it to the result list
            ListNode newNode = new ListNode(num);
            tail.next = newNode;
            tail = tail.next; 

            // Move to the next nodes in both lists
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        ListNode result = head.next;
        head.next = null; 
        return result; 
    }
}