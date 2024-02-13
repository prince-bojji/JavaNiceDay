package week1.Exceptions;

public class UncheckedExceptions {
    public static void main(String [] args) {
        try {
            // Code that might throw an unchecked exception
            int a = 5, b = 0;
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // Handle the ArithmeticException
            System.out.println("Error: Division by zero.");
        }
    }
}

