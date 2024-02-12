# Object Oriented Programming

___Packages___ this is like a folder in directory where we can throw all our related codes in the same directory.

___Built-in Packages___ Java API has many pre-written classes to help the programmer manage input, database, and etc.

### Inporting Packages

___Import Specific Class___
```bash
import packagename.classname;
```
___Import Whole Package___
```bash
import packagename.*;
```

___Access Modifiers___ used to modify where classes, variables, and methods are accessible.

### Classes
| Modifier | Description                               |
|-----------------|-------------------------------------------|
| default         | The class can only be accessed by the classes on the same package. |
| public       | The class can only be accessed anywhere as long as it is imported. |

### Methods and Variables
| Modifier | Description                               |
|-----------------|-------------------------------------------|
| default         | It can only be accessed by classes on the same package. |
| public       | It can only be accessed anywhere as long as it is imported. |
| private         | It can only be accessed insided its own class. |
| protected       | It can only be accessed by the classes in the same package and subclasses. |

___Non-Access Modifiers___ used to add other functionalities for classes, variables and methods, it is basically used for specific situations.

### Classes
| Modifier | Description                               |
|-----------------|-------------------------------------------|
| final         | This classes cannot be inherited by another classes. |
| abstract       | This class cannot be used to instantiate objects. We can only access abstract class by inheriting it from another class. |

### Methods and Variables
| Modifier | Description                               |
|-----------------|-------------------------------------------|
| final         | Variables cannot be reassigned. Methods cannot be overriden |
| static       | The variables/methods belong to the class itself is rather than its instance. |
| abstract         | It can only be used in an abstract class, methods. This method does not have a body. |

___Object-oriented programming___ It focuses on implementing real world objects using classes to create variations of objects that has attributes and purpose.

___Classes___ it will act as a blueprint of an object you want to implement on your program.

___Class Instantiation___ the process of creating an instance of a class.

___Attributes___ these are the global variables declared inside the class of our object.

[Object Class](https://github.com/prince-bojji/JavaNiceDay/tree/main/JavaDevelopment/src/week1/OOP/objectsClass)

### 4 Pillars of OOP
1. [Encaptulation](https://github.com/prince-bojji/JavaNiceDay/tree/main/JavaDevelopment/src/week1/OOP/encaptulation)
2. [Inheritance](https://github.com/prince-bojji/JavaNiceDay/tree/main/JavaDevelopment/src/week1/OOP/inheritance)
3. [Polymorphism](https://github.com/prince-bojji/JavaNiceDay/tree/main/JavaDevelopment/src/week1/OOP/polymorphism)
4. [Abstraction](https://github.com/prince-bojji/JavaNiceDay/tree/main/JavaDevelopment/src/week1/OOP/abstraction)