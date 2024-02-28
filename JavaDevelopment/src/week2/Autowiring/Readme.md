## Autowiring

**_Autowiring_** in Spring is a mechanism that automates the injection of dependencies into Spring-managed beans, reducing configuration overhead. It simplifies the process by allowing Spring to resolve and inject dependencies based on predefined rules.

### Autowiring Modes:

### 1. byType:

In this mode, Spring looks for a bean of the same type as the dependency and injects it. If there's only one bean of the required type, it's injected. However, if multiple beans of the same type exist, Spring throws an exception.

### Example:

```bash
public class UserService {
    @Autowired
    private UserRepository userRepository; // Autowiring by type
    // UserService methods...
}
```

### 2. byName:

Here, Spring looks for a bean with a name matching the dependency and injects it. If no matching bean is found, Spring throws an exception.

### Example:

```bash
public class UserService {
    @Autowired
    private UserRepository userRepo; // Autowiring by name
    // UserService methods...
}
```

### 3. constructor:

Spring attempts to match constructor arguments with beans available in the container based on their types.

### Example:

```bash
public class UserService {
    private final UserRepository userRepository;
    // Constructor autowiring
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // UserService methods...
}
```

### 4. no:

In this mode, no autowiring occurs. Dependencies must be wired explicitly using XML or annotations.

### Example:

```bash
public class UserService {
    private final UserRepository userRepository;

    // Manual wiring
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // UserService methods...
}
```

### 5. autodetect: 

This mode is a combination of constructor and byType autowiring. Spring first tries constructor autowiring, and if that's not feasible, it resorts to byType autowiring.

Same as constructor autowiring example.
