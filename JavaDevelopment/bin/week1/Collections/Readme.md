# Collections

The **_Collection APIs_** provide a set of interfaces and classes to represent groups of objects, known as collections, and manipulate them in a standardized way. Collections allow you to `store`, `retrieve`, `manipulate`, and `process` data efficiently. The Collection framework includes interfaces like `List`, `Set`, `Map`, and their implementing classes like `ArrayList`, `HashSet`, `HashMap`, etc.

### Collection Interfaces

1. **_List_** Ordered collection of elements that allows duplicate elements. Examples: `ArrayList`, `LinkedList`.

2. **_Set_** Unordered collection of unique elements. Examples: `HashSet`, `TreeSet`.

3. **_Map_** Key-value pairs where each key is associated with exactly one value. Examples: `HashMap`, `TreeMap`.

### Sorting

#### Natural Order
```java
list.sort(null);
```

#### Reverse Order
```java
list.sort(Comparator.reverseOrder());
```

You can also use:
```java
Collections.sort(list);
```

### Iterating List

#### Using Loop
You can use a traditional for loop or an enhanced for loop.

#### Using Iterator
```java
Iterator<String> iterator = fruits.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

#### Using Streams (forEach)
```java
fruits.stream().forEach(System.out::println);
```

[Sample Collections Implementation](https://github.com/prince-bojji/JavaNiceDay/tree/main/JavaDevelopment/src/week1/Collections)

After completing this lesson, you may proceed to the exercises folder, [Exercises](https://github.com/prince-bojji/JavaNiceDay/tree/main/JavaDevelopment/src/week1/Exercises)


