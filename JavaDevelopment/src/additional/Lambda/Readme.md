# Lambda Expression

A **lambda expression** is a short block of code which takes in parameters and returns a value. Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.

## Syntax

The simplest lambda expression contains a single parameter and an expression:
```
parameter -> expression
```

```java
import java.util.function.Function; 

public class SingleParameterLambda {
    public static void main(String[] args) {
        Function<Integer, Integer> square = x -> x * x;
        int result = square.apply(5);
        System.out.println("Square of 5: " + result);
    }
}
```

To use more than one parameter, wrap them in parentheses:
```
(parameter1, parameter2) -> expression
```

```java
import java.util.function.BiFunction;

public class MultiParameterLambda {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        int result = add.apply(10, 15);
        System.out.println("Sum: " + result);
    }
}
```

Expressions are limited. They have to immediately return a value, and they cannot contain variables, assignments or statements such as `if` or `for`. In order to do more complex operations, a code block can be used with curly braces. If the lambda expression needs to return a value, then the code block should have a return statement.

```
(parameter1, parameter2) -> { code block }
```

```java
import java.util.function.BiFunction;

public class CodeBlockLambda {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, String> compare = (x, y) -> {
            if (x > y) {
                return x + " is greater";
            } else if (x < y) {
                return y + " is greater";
            } else {
                return "Both are equal";
            }
        };

        String result = compare.apply(20, 15);
        System.out.println(result);
    }
}
```

## Using Lambda Expressions

### Example

Use a lambda expression in the ArrayList's `forEach()` method to print every item in the list:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);
        numbers.forEach((n) -> { System.out.println(n); });
    }
}
```
