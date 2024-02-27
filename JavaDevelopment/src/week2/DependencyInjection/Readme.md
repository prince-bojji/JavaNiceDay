## Dependency Injection

___Dependency Injection (DI)___  in Spring is a design pattern and a core concept that enables the decoupling of components in an application by allowing objects to be injected with their dependencies rather than creating them internally. This promotes easier testing, better code maintainability, and scalability.

In Spring, DI is facilitated primarily through ___Inversion of Control (IoC)___  containers, such as the `ApplicationContext`, which manages the creation and configuration of objects. 

### There are mainly three types of DI in Spring:

1. ___Constructor Injection:___ Dependencies are provided through a class constructor.
2. ___Setter Injection:___ Dependencies are set through setter methods.
3. ___Field Injection:___ Dependencies are injected directly into the fields of a class.

Out of the three, ___Constructor Injection___ is the most commonly used. See the example below: 

```bash
package com.example;

/*
 * Suppose we have an interface CCIS that defines a method record()
 */

public interface CCIS {
    public void record(String record);
}
```

```bash
package com.example;

/*
 * We'll implement this interface with a simple implementation
 */

public class Student implements CCIS {
    @Override
    public void record(String record) {
        System.err.println("Record: " + record);
    }   
}
```

```bash
package com.example;

/*
 * Now, let's create another class RecordProcessor that depends on CCIS
 */

public class RecordProcessor {
    private final CCIS ccis;

    public RecordProcessor(CCIS ccis) {
        this.ccis = ccis;
    }

    public void processRecord(String record){
        ccis.record(record);
    }
}
```

```bash
package com.example;

/*
 * Now, let's configure these beans in Spring configuration (using @Configuration and @Bean annotations)
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CCIS student(){
        return new Student();
    }

    @Bean
    public RecordProcessor recordProcessor(CCIS ccis){
        return new RecordProcessor(ccis);
    }
}
```

```bash
package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * Now, let's use these beans in our application
 */

public class App 
{
    public static void main( String[] args )
    {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)){

        RecordProcessor processor = context.getBean(RecordProcessor.class);
        processor.processRecord("student-id");
        }
    }
}
```

