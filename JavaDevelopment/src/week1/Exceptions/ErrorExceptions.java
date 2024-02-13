package week1.Exceptions;

public class ErrorExceptions {
    public static void main(String [] args) {
        try {
            // Code that might throw an error
            throw new OutOfMemoryError("Memory exhausted");
        } catch (OutOfMemoryError e) {
            // Handle the OutOfMemoryError
            System.out.println("Out of memory error occurred: " + e.getMessage());
        }
    }
}

