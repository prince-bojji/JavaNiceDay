# Exercises

You may push your work to the respective exercises folder, and you can create your own folder.

## Exercise 1: Java Fundamentals

### Mortgage Calculator

```bash
Principal (1k - 1m): 100000
Annual Interest Rate (1 - 30): 3
Period (years) (1 - 30): 30
Mortgage: $472.81
```

Formula: M = P [ i (1 + i)^n ] / [ (1 + i)^n – 1]

Here’s a breakdown of each of the variables:

- M = Total monthly payment
- P = The total amount of your loan
- I = Your interest rate, as a monthly percentage
- N = The total amount of months in your timeline for paying off your mortgage

## Exercise 2: Object Oriented Programming

Apply what you have learned in OOP lessons to enhance the second exercise, which is the mortgage calculator.

## Exercise 3: Generics

**_Problem:_** Develop a generic class to manage a collection of different types of elements. Implement methods to add elements, remove elements by index, and retrieve elements by index.

### Details:

1. Create a generic class called `CustomCollection<E>` where `E` represents the type of elements to be stored.
2. Implement methods `void add(E element)`, `void remove(int index)`, and `E get(int index)`.
3. Ensure type safety by using generics.
4. Test your class with various data types such as Integer, String, and custom objects.

## Exercise 4: Collections

### Add Two Numbers

You are given two **_non-empty_** linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

### Example 1:

![Exercise 4](https://raw.githubusercontent.com/prince-bojji/JavaNiceDay/main/JavaDevelopment/src/week1/Exercises/images/exercise4.png)

**_Input:_** l1 = [2,4,3], l2 = [5,6,4]
**_Output:_** [7,0,8]
**_Explanation:_** 342 + 465 = 807.

### Example 2:

**_Input:_** l1 = [0], l2 = [0]
**_Output:_** [0]

### Example 3:

**_Input:_** l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
**_Output:_** [8,9,9,9,0,0,0,1]

### Constraints:

- The number of nodes in each linked list is in the range `[1, 100]`.
- `0 <= Node.val <= 9`
- It is guaranteed that the list represents a number that does not have leading zeros.

## Exercise 5: Concurrency APIs and Multi-threading

**_Problem:_** Develop a multi-threaded Java program that simulates a restaurant's kitchen with chefs preparing different dishes concurrently.

### Details:

1. Create a class `Chef` representing a chef in the kitchen.
2. Implement methods for each dish to be prepared, such as `preparePasta()`, `preparePizza()`.
3. Use Java's concurrency utilities to create multiple instances of `Chef` running concurrently.
4. Implement synchronization mechanisms to prevent conflicts when accessing shared resources like kitchen equipment.
5. Demonstrate the use of thread pools to manage the execution of chef tasks efficiently.
