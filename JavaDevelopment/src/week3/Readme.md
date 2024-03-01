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

### @Qualifier Annotation

The **_@Qualifier_** annotation is used in conjunction with **_@Autowired_** to avoid confusion when we have two or more beans configured for the same type.

If there are multiple implementations for a single interface then we can use **_@Qualifier_** to choose the required implementation at runtime.

### Example

```bash
public interface MessageService {
    public void sendMsg(String message);
}
```

```bash
public class EmailService implements MessageService{

    public void sendMsg(String message) {
         System.out.println(message);
    }
}
```

```bash
public class TwitterService implements MessageService{

    public void sendMsg(String message) {
        System.out.println(message);
    }
}
```

```bash
public class SMSService implements MessageService{

    public void sendMsg(String message) {
         System.out.println(message);
    }
}
```

```bash
public interface MessageProcessor {
    public void processMsg(String message);
}

public class MessageProcessorImpl implements MessageProcessor {

    private MessageService messageService;

    // setter based DI
    @Autowired
    @Qualifier("twitterService")
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    // constructor based DI
    @Autowired
    public MessageProcessorImpl(@Qualifier("twitterService") MessageService messageService) {
        this.messageService = messageService;
    }

    public void processMsg(String message) {
        messageService.sendMsg(message);
    }
}
```

```bash
@Configuration
@ComponentScan("com.javadevsguide.springframework.di")
public class AppConfiguration {

    @Bean(name="emailService")
    public MessageService emailService(){
         return new EmailService();
    }

    @Bean(name="twitterService")
    public MessageService twitterService(){
        return new TwitterService();
    }

    @Bean(name="smsService")
    public MessageService smsService(){
        return new SMSService();
    }

    @Bean
    public MessageProcessor messageProcessor(){
        return new MessageProcessorImpl(twitterService());
    }
}
```

```bash
public class TestApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        MessageProcessor processor = applicationContext.getBean(MessageProcessor.class);
        processor.processMsg("twitter message sending ");
    }
}
```