## Dependency Injection

___Dependency Injection (DI)___  in Spring is a design pattern and a core concept that enables the decoupling of components in an application by allowing objects to be injected with their dependencies rather than creating them internally. This promotes easier testing, better code maintainability, and scalability.

In Spring, DI is facilitated primarily through ___Inversion of Control (IoC)___  containers, such as the `ApplicationContext`, which manages the creation and configuration of objects. 

### There are mainly three types of DI in Spring:

1. ___Constructor Injection:___ Dependencies are provided through a class constructor.
2. ___Setter Injection:___ Dependencies are set through setter methods.
3. ___Field Injection:___ Dependencies are injected directly into the fields of a class.

Out of the three, ___Constructor Injection___ is the most commonly used.