# Streams

Streams in Java provide a modern and functional way to process collections of data. They allow performing operations such as filtering, mapping, and reducing data efficiently and concisely.

## Stream Operations

Streams support two types of operations:

1. **Intermediate operations**: Return another stream (e.g., `filter`, `map`, `sorted`). These are lazy and do not perform the actual processing until a terminal operation is invoked.
2. **Terminal operations**: Produce a result or a side effect (e.g., `forEach`, `collect`, `reduce`).

## Creating Streams

### From a Collection

```java
import java.util.List;
import java.util.stream.Stream;

public class StreamFromCollection {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        Stream<String> nameStream = names.stream();
        nameStream.forEach(System.out::println);
    }
}
```

### Using `Stream.of()`

```java
import java.util.stream.Stream;

public class StreamOfExample {
    public static void main(String[] args) {
        Stream<Integer> numberStream = Stream.of(1, 2, 3, 4, 5);
        numberStream.forEach(System.out::println);
    }
}
```

## Common Stream Operations

### `filter()` - Filter elements based on a condition

```java
import java.util.List;
import java.util.stream.Collectors;

public class FilterExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(n -> n % 2 == 0)
                                           .collect(Collectors.toList());
        System.out.println("Even Numbers: " + evenNumbers);
    }
}
```

### `map()` - Transform each element

```java
import java.util.List;
import java.util.stream.Collectors;

public class MapExample {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        List<String> uppercasedNames = names.stream()
                                            .map(String::toUpperCase) // String::toUpperCase in lambda is s -> s.toUpperCase()
                                            .collect(Collectors.toList());
        System.out.println(uppercasedNames);
    }
}
```

### `sorted()` - Sort the stream

```java
import java.util.List;

public class SortedExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(5, 3, 1, 4, 2);
        numbers.stream()
               .sorted() // Integer::compareTo in lambda is (a, b) -> a.compareTo(b)
               .forEach(System.out::println);
    }
}
```

### `forEach()` - Perform an action for each element

```java
import java.util.List;

public class ForEachExample {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        names.stream().forEach(name -> System.out.println("Hello, " + name));
    }
}
```

### `reduce()` - Combine elements into a single result

```java
import java.util.List;

public class ReduceExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                          .reduce(0, Integer::sum); // Integer::sum in lambda is (a, b) -> a + b
        System.out.println("Sum: " + sum);
    }
}
```

## Using Stream Operations Together

### Example

Combine `filter()`, `map()`, and `forEach()` to process a list of numbers:

```java
import java.util.List;

public class CombinedOperations {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        numbers.stream()
               .filter(n -> n % 2 == 0)
               .map(n -> n * n)
               .forEach(System.out::println);
    }
}
```
