# Week 3

## Spring Boot

**_Spring Boot_** is an opinionated, easy to get-started addition to the Spring platform – highly useful for creating stand-alone, production-grade applications with minimum effort.

## Spring & Spring Boot Annotations

### @Component Annotation

The **_@Component_** annotation indicates that an annotated class is a "component". Such classes are considered candidates for auto-detection when using annotation-based configuration and classpath scanning.

In short, **_@Component_** is a class-level annotation. During the component scan, Spring Framework automatically detects classes annotated with @Component annotation and creates Spring beans for those classes.

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

### Autowired Annotation

The **_@Autowired_** annotation is used to inject the bean automatically.

The **_@Autowired_** annotation is used in Constructor injection, Setter injection, and Field injection.

### Example

```bash
package net.javaguides.springboot.controller;

import net.javaguides.springboot.service.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PizzaController {

    //Field injection
    @Autowired
    @Qualifier("vegPizza")
    private Pizza pizza;

//    @Autowired
//    public PizzaController(@Qualifier("vegPizza") Pizza pizza) {
//        System.out.println("inside PizzaController constructor");
//        this.pizza = pizza;
//    }

//    // setter injection
//    @Autowired
//    @Qualifier("vegPizza")
//    public void setPizza(Pizza pizza) {
//        this.pizza = pizza;
//    }

    public String getPizza(){
        return pizza.getPizza();
    }
}
```

```bash
package net.javaguides.springboot;

import net.javaguides.springboot.controller.PizzaController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringbootDockerDemoApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(SpringbootDockerDemoApplication.class, args);
		System.out.println("calling pizzaController.getPizza()");
		PizzaController pizzaController = context.getBean(PizzaController.class);
		String message = pizzaController.getPizza();
		System.out.println(message);
	}
}
```
