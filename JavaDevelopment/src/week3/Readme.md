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


### Primary Annotation

We use **_@Primary_** annotation to give higher preference to a bean when there are multiple beans of the same type.

### Bean Annotation

**_@Bean_** annotation indicates that a method produces a bean to be managed by the Spring container. The @Bean annotation is usually declared in the Configuration class to create Spring Bean definitions.

### Example

### Declaring a Bean

```bash
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.companyname.projectname.customer.CustomerService;
import com.companyname.projectname.order.OrderService;

@Configuration
public class Application {

    @Bean
    public CustomerService customerService() {
        return new CustomerService();
    }

    @Bean
    public OrderService orderService() {
       return new OrderService();
    }
}
```

### Injecting Bean Dependencies

```bash
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.companyname.projectname.customer.CustomerController;
import com.companyname.projectname.customer.CustomerService;

@Configuration
public class Application {

    private CustomerService customerService;
    @Bean
    public CustomerService customerService() {
        customerService = new CustomerService();
        return customerService;
    }

    @Bean
    public CustomerController customerController(CustomerService customerService) {
        return new CustomerController(customerService);
    }
}
```

### Bean life cycle methods

@Bean annotation provides initMethod and destroyMethod attributes to perform certain actions after bean initialization or before bean destruction by a container.

```bash
public class Foo {
        public void init() {
                // initialization logic via xml config
        }
}

public class Bar {
        public void cleanup() {
                // destruction logic via xml config
        }
}

@Configuration
public class AppConfig {

        @Bean(initMethod = "init")
        public Foo foo() {
                return new Foo();
        }

        @Bean(destroyMethod = "cleanup")
        public Bar bar() {
                return new Bar();
        }

}
```

### Specifying Bean Scope Using the @Scope Annotation

```bash
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.companyname.projectname.customer.CustomerService;
import com.companyname.projectname.order.OrderService;

@Configuration
public class Application {

    @Bean
    @Scope("prototype")
    public CustomerService customerService() {
        return new CustomerService();
    }

    @Bean
    @Scope("prototype")
    public OrderService orderService() {
        return new OrderService();
    }
}
```

### Customizing Bean Naming

```bash
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.companyname.projectname.customer.CustomerService;
import com.companyname.projectname.order.OrderService;

@Configuration
public class Application {

    @Bean(name = "cService")
    public CustomerService customerService() {
        return new CustomerService();
    }

    @Bean(name = "oService")
    public OrderService orderService() {
        return new OrderService();
    }
}
```

### Bean Aliasing

```bash
@Configuration
public class AppConfig {

        @Bean(name = { "dataSource", "subsystemA-dataSource", "subsystemB-dataSource" })
        public DataSource dataSource() {
                // instantiate, configure and return DataSource bean...
        }

}
```

### Injecting inter-bean dependencies

```bash
@Configuration
public class AppConfig {
        @Bean
        public Foo foo() {
                return new Foo(bar());
        }

        @Bean
        public Bar bar() {
                return new Bar();
        }
}
```


### Stereotype Annotations

Spring Stereotype annotations are used to create Spring beans automatically in the application context (Spring IoC container).

The main stereotype annotation is **_@Component_** . By using this annotation, Spring provides more Stereotype meta-annotations such as @Service, @Repository, and @Controller.

**_@Service_** annotation is used to create Spring beans at the Service layer.

**_@Repository_** is used to create Spring beans for the repositories at the DAO layer.

**_@Controller_** is used to create Spring beans at the controller layer.

### Examples

### @Component

```bash
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class AnotherBean {
    @Autowired
    private HelloWorldComponent helloWorldComponent;

    public void printHello() {
        helloWorldComponent.printHello();
    }
}
```

### @Service

```bash
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
      // All the service layer logic goes here
}
```

### @Repository

```bash
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
      // All the dao layer logic goes here
}
```

### Controller

```bash
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
      // Build REST APIs
}
```


### @Lazy Annotation

By default, the Spring IoC container creates and initializes all singleton beans at the time of application startup. We can prevent this pre-initialization of a singleton bean by using the @Lazy annotation.

The **_@Lazy_** annotation may be used on any class directly or indirectly annotated with @Component or on methods annotated with @Bean.

### Example

```bash
package net.javaguides.spring.lazy;

public class FirstBean {

    public FirstBean() {
        System.out.println("Inside FirstBean Constuctor");
    }

    public void test() {
        System.out.println("Method of FirstBean Class");
    }
}
```

```bash
package net.javaguides.spring.lazy;

public class SecondBean {

    public SecondBean() {
        System.out.println("Inside SecondBean Constuctor");
    }

    public void test() {
        System.out.println("Method of SecondBean Class");
    }
}
```

````bash
package net.javaguides.spring.lazy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class AppConfig {

    @Lazy(value = true)
    @Bean
    public FirstBean firstBean() {
        return new FirstBean();
    }

    @Bean
    public SecondBean secondBean() {
        return new SecondBean();
    }
}
```

```bash
package net.javaguides.spring.lazy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        FirstBean firstBean = context.getBean(FirstBean.class);
        firstBean.test();
        context.close();
    }
}
```

```bash
// Output
Inside SecondBean Constuctor
Inside FirstBean Constuctor
Method of FirstBean Class
```


### @Scope Annotation

We use **_@Scope_** to define the scope of a **_@Component_** class or a **_@Bean_** definition.

The **_@Scope_** annotation can use with all Spring bean scopes:

1. **_Singleton:_** only one instance of the bean is created and shared across the entire application. This is the default scope.

2. **_Prototype:_** a new instance of the bean is created every time it is requested.

3. **_Request:_** a new instance of the bean is created for each HTTP request. It is only applicable to web applications.

4. **_Session:_** a new instance of the bean is created for each HTTP session. It is only applicable to web applications.

5. **_Application:_** a single instance of the bean is created and shared across the entire application context. It is only applicable to web applications.

### @Scope Annotation + Prototype Scope + @Component Example

```bash
package net.javaguides.spring.scope;

public interface MessageService {

    String getMessage();

    void setMessage(String message);
}
```

```bash
package net.javaguides.spring.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TwitterMessageService implements MessageService {

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
```

```bash
package net.javaguides.spring.scope;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "net.javaguides.spring")
public class AppConfig {

}
```

```bash
package net.javaguides.spring.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
         AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(AppConfig.class);
         MessageService messageService = context.getBean(MessageService.class);
         messageService.setMessage("TwitterMessageService Implementation");
         System.out.println(messageService.getMessage());

         MessageService messageService1 = context.getBean(MessageService.class);
         System.out.println(messageService1.getMessage());
         context.close();
    }
}
```

```bash
// Output
TwitterMessageService Implementation
null
```

### @Scope Annotation + Prototype Scope + @Bean Example

```bash
package net.javaguides.spring.scope;

public interface MessageService {

    String getMessage();

    void setMessage(String message);
}
```

```bash
package net.javaguides.spring.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class TwitterMessageService implements MessageService {

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
```

```bash
package net.javaguides.spring.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public MessageService messageService() {
        return new TwitterMessageService();
    }
}
```

```bash
package net.javaguides.spring.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(AppConfig.class);
        MessageService messageService = context.getBean(MessageService.class);
        messageService.setMessage("TwitterMessageService Implementation");
        System.out.println(messageService.getMessage());

        MessageService messageService1 = context.getBean(MessageService.class);
        System.out.println(messageService1.getMessage());
        context.close();
    }
}
```

```bash
// Output
TwitterMessageService Implementation
null
```


### @Value Annotation

Spring **_@Value_** annotation is used to assign default values to variables and method arguments.

The **_@Value_** annotation is mostly used to get value for specific property keys from the properties file.

We can read spring environment variables as well as system variables using **_@Value_** annotation.

### Example

In this example, we will see how to use @Value annotation to read the value for a property key, and read environment variables as well as system variables.

Add the below properties to the `application.properties` file:

```bash
mail.email=javaguides@gmail.com
mail.host=gmail.com
mail.password=password
```

```bash
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueAnnotationDemo {

    @Value("default value")
    private String testDefaultValue;

    @Value("${java.home}")
    private String javaHome;

    @Value("${HOME}")
    private String homeDir;

    @Value("${mail.email}")
    private String email;

    @Value("${mail.host}")
    private String host;

    @Value("${mail.password}")
    private String password;

    public String getTestDefaultValue() {
        return testDefaultValue;
    }

    public String getJavaHome() {
        return javaHome;
    }

    public String getHomeDir() {
        return homeDir;
    }

    public String getEmail() {
        return email;
    }

    public String getHost() {
        return host;
    }

    public String getPassword() {
        return password;
    }
}
```

```bash
import net.javaguides.springboot.config.ValueAnnotationDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		var context = SpringApplication.run(SpringbootDockerDemoApplication.class, args);
		ValueAnnotationDemo valueAnnotationDemo = context.getBean(ValueAnnotationDemo.class);
		System.out.println(valueAnnotationDemo.getTestDefaultValue());
		System.out.println(valueAnnotationDemo.getHost());
		System.out.println(valueAnnotationDemo.getEmail());
		System.out.println(valueAnnotationDemo.getPassword());
		System.out.println(valueAnnotationDemo.getJavaHome());
		System.out.println(valueAnnotationDemo.getEmail());
		System.out.println(valueAnnotationDemo.getHomeDir());
	}
}
```

```bash
// Output
default value
gmail.com
javaguides@gmail.com
password
/Users/rameshfadatare/Library/Java/JavaVirtualMachines/openjdk-17.0.2/Contents/Home
javaguides@gmail.com
/Users/rameshfadatare
```


### @PropertySource Annotation

In Spring, you can use **_@PropertySource_** annotation to externalize your configuration to a properties file. In this article, we will discuss how to use **_@PropertySource_** to read a properties file and display the values with **_@Value_** and **_Environment_**.

The **_@PropertySource_** annotation provides a convenient and declarative mechanism for adding a **_PropertySource_** to Spring’s Environment. To be used in conjunction with **_@Configuration_** classes.

### @PropertySource Annotation with Simple Example

```bash
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:config.properties")
public class ProperySourceDemo implements InitializingBean {

    @Autowired
    Environment env;

    @Override
    public void afterPropertiesSet() throws Exception {
        setDatabaseConfig();
    }

    private void setDatabaseConfig() {
        DataSourceConfig config = new DataSourceConfig();
        config.setDriver(env.getProperty("jdbc.driver"));
        config.setUrl(env.getProperty("jdbc.url"));
        config.setUsername(env.getProperty("jdbc.username"));
        config.setPassword(env.getProperty("jdbc.password"));
        System.out.println(config.toString());
    }
}
```

### Spring @PropertySource Annotation Placeholders Example

```bash
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/com/${my.placeholder:default/path}/config.properties")
public class ProperySourceDemo implements InitializingBean {

    @Autowired
    Environment env;

    @Override
    public void afterPropertiesSet() throws Exception {
        setDatabaseConfig();
    }

    private void setDatabaseConfig() {
       DataSourceConfig config = new DataSourceConfig();
       config.setDriver(env.getProperty("jdbc.driver"));
       config.setUrl(env.getProperty("jdbc.url"));
       config.setUsername(env.getProperty("jdbc.username"));
       config.setPassword(env.getProperty("jdbc.password"));
       System.out.println(config.toString());
    }
}
```

### @PropertySources Annotation - Include multiple properties files

```bash
@Configuration
 @PropertySources({
  @PropertySource("classpath:config.properties"),
  @PropertySource("classpath:db.properties")
 })
 public class AppConfig {
  //...
 }
```

Allow **_@PropertySource_** to ignore the not found properties file.

```bash
 @Configuration
 @PropertySource("classpath:missing.properties")
 public class AppConfig {
  //...
 }
```

If ___missing.properties___ is not found, the system is unable to start and throws ___FileNotFoundException___

```bash
 Caused by: java.io.FileNotFoundException: 
  classpath resource [missiong.properties] cannot be opened because it does not exist
```

In Spring 4, you can use ___ignoreResourceNotFound___ to ignore the not found properties file

```bash
 @Configuration
 @PropertySource(value="classpath:missing.properties", ignoreResourceNotFound=true)
 public class AppConfig {
  //...
 }

        @PropertySources({
  @PropertySource(value = "classpath:missing.properties", ignoreResourceNotFound=true),
  @PropertySource("classpath:config.properties")
        })
```