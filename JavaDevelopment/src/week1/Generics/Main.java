package week1.Generics;

public class Main {
    public static void main(String[] args) {
        // Creating a Box for Integer
        GenericsList<Integer> integerBox = new GenericsList<>();
        integerBox.add(10);
        int intValue = integerBox.get(); // No casting needed
        System.out.println(intValue);

        // Creating a Box for String
        GenericsList<String> stringBox = new GenericsList<>();
        stringBox.add("Hello");
        String stringValue = stringBox.get(); // No casting needed
        System.out.println(stringValue);
    }
}
