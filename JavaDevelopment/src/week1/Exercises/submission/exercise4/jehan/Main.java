package week1.exercises.submission.exercise4.jehan;

public class Main {
    public static void main(String[] args) {
        // First List
        ListNode l1;
        l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Second List
        ListNode l2;
        l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);

        System.out.println("Sum of two numbers:");
        while (result != null) {
            System.out.print(result.value);
            if (result.next != null) {
                System.out.print(" -> ");
            }
            result = result.next;
        }
    }
}




