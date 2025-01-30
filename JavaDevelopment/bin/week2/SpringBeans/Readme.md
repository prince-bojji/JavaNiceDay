## Spring Beans

In Spring Framework, beans are Java objects managed by the Spring IoC (Inversion of Control) container. Beans serve as the fundamental building blocks of a Spring application, instantiated, assembled, and managed by the Spring container. They can be defined using Java classes, XML configuration, or annotations.

### Bean Scope:

Bean scope determines the lifecycle and visibility of a bean within the Spring IoC container. Spring offers several scopes including:

1. ___Singleton:___ Only one instance of the bean is created per container.
2. ___Prototype:___ A new instance of the bean is created whenever requested.
3. ___Request:___ A new instance of the bean is created for each HTTP request in a web application.
4. ___Session:___ A new instance of the bean is created for each HTTP session in a web application.
5. ___Global Session:___ Similar to the session scope, but applicable for portlet-based web applications.

### Bean Lifecycle:

The lifecycle of a Spring bean involves:

1. ___Instantiation:___ Creating the bean either through constructors or factory methods.
2. ___Dependency Injection:___ Injecting dependencies into the bean.
3. ___Initialization:___ Performing custom initialization logic after dependency injection.
4. ___Use:___ Utilizing the bean within the application.
5. ___Destruction:___ Releasing resources held by the bean when it's no longer needed.

### Examples:

### Bean Declaration (Singleton Scope):

```bash
<bean id="mySingletonBean" class="com.example.MySingletonBean"/>
```

### Bean Declaration (Prototype Scope):

```bash
<bean id="myPrototypeBean" class="com.example.MyPrototypeBean" scope="prototype"/>
```

### Bean Initialization (Lazy Initialization):

```bash
<bean id="myLazySingletonBean" class="com.example.MyLazySingletonBean" lazy-init="true"/>
```

### Bean Initialization (Eager Initialization):

```bash
<bean id="myEagerSingletonBean" class="com.example.MyEagerSingletonBean" lazy-init="false"/>
```