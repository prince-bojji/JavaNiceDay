## Spring Core

**_Spring Core_** is a fundamental aspect of the Spring Framework, providing essential functionalities such as `ApplicationContext`, `BeanFactory`, and `PropertyPlaceholderConfigurer`.

### ApplicationContext:

- **_ApplicationContext_** is an interface representing the Spring IoC container, responsible for instantiating, configuring, and managing beans.
- **_ApplicationContext_** is an advanced container that builds on the capabilities of the BeanFactory. It supports internationalization, event propagation, resource loading, and application-layer specific contexts (e.g., web application context). ApplicationContext also supports AOP (Aspect-Oriented Programming) features.

### Example:

```bash
ApplicationContext context = new ClassPathXmlApplicationContext("applicationContextxml");
MyService service = (MyService) context.getBean("myService");
service.doSomething();
```

### BeanFactory:

- **_BeanFactory_** is the core interface for accessing and managing beans in the Spring IoC container.
- **_BeanFactory_** is the simplest container providing basic support for dependency injection (DI). It instantiates beans, resolves bean dependencies, and manages bean lifecycles. It provides a lightweight container with lazy-loading of beans.

### Example:

```bash
BeanFactory factory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
MyBean bean = (MyBean) factory.getBean("myBean");
bean.doSomething();
```

### PropertyPlaceholderConfigurer:

- ___PropertyPlaceholderConfigurer___ is a bean factory post-processor that replaces ${...} placeholders with property values.
- ___PropertyPlaceholderConfigurer___ allows you to externalize configuration such as database settings, file paths, etc., into a properties file. It resolves placeholders in bean definitions or any other text-based resources. This enables easy configuration management without modifying the application code.

### Examples:

```bash
<bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
    <property name="location" value="classpath:config.properties"/>
</bean>

<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
    <property name="driverClassName" value="${jdbc.driverClassName}"/>
    <property name="url" value="${jdbc.url}"/>
    <property name="username" value="${jdbc.username}"/>
    <property name="password" value="${jdbc.password}"/>
</bean>
```

In the example above, `${jdbc.driverClassName}`, `${jdbc.url}`, `${jdbc.username}`, and `${jdbc.password}` are replaced by values from config.properties file at runtime.
