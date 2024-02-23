package week1.exercises.submission.exercise3.jehan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomCollection<String> stringCollection = new CustomCollection<>(2);
        // Add elements
        stringCollection.add("Jehan");
        stringCollection.add("Batang");
        stringCollection.add("Mary");
        stringCollection.add("Grace");
        stringCollection.add("Arboladura");

        //Remove elements
        stringCollection.remove(3);

        // Get elements
        System.out.println("\nDisplay String elements: ");
        for(int i = 0; i < stringCollection.getCount(); i++) 
            System.out.println(stringCollection.get(i)); 

        // Integer Collection (getting user input naman para maiba)
        CustomCollection<Integer> integerCollection = new CustomCollection<>(2);
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("\nEnter how many integers you want : ");  
        int n = scanner.nextInt();  

        // Add elements 
        System.out.println("\nEnter " + n + " integers : ");
        for(int i = 0; i < n; i++){
            integerCollection.add(scanner.nextInt());
        }

        // Remove elements
        System.out.print("\nEnter what index of elements you want to remove : ");
        int index = scanner.nextInt();
        integerCollection.remove(index);

        // Get elements
        System.out.println("\nDisplay Integer elements: ");
        for(int i = 0; i < integerCollection.getCount(); i++) 
            System.out.println(integerCollection.get(i)); 

        scanner.close();
    }
}
