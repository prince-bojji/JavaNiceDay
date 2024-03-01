# Week 3

## Spring Boot

___Spring Boot___ is an opinionated, easy to get-started addition to the Spring platform – highly useful for creating stand-alone, production-grade applications with minimum effort.

## Spring & Spring Boot Annotations

### @Component Annotation

The ___@Component___ annotation indicates that an annotated class is a "component". Such classes are considered candidates for auto-detection when using annotation-based configuration and classpath scanning.
 
In short, ___@Component___ is a class-level annotation. During the component scan, Spring Framework automatically detects classes annotated with @Component annotation and creates Spring beans for those classes.

### Example

Note that the created ApplicationContext and retrieved ComponentDemo bean using getBean() Method.

```bash
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
        ComponentDemo componentDemo = (ComponentDemo) applicationContext.getBean("componentDemo");
        System.out.println(componentDemo.getValue());
    }
}

@Component
class ComponentDemo {
    public String getValue() {
        return "Hello World";
    }
}
```

By default, the bean instances of this class have the same name as the class name with a lowercase initial. On top of that, we can specify a different name using the optional value argument of this annotation.

```bash
@Component("componentDemo")
class ComponentDemo {
    public String getValue() {
        return "Hello World";
    }
}
```

