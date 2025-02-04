# Hibernate 

Hibernate is an Object-Relational Mapping (ORM) framework that simplifies database interactions by mapping Java objects to database tables.

## Entity Mapping (@Entity, @Table)

**Explanation:**

- `@Entity`: Marks a class as a persistent entity managed by Hibernate.
- `@Table`: Specifies the corresponding table name in the database (optional if the class name matches the table name).

**Example:**

```java
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    private int id;
    private String name;
    private int age;

    // Getters and Setters
}
```

## Relationships in Hibernate

Hibernate supports various relationships between entities:

- One-to-One (`@OneToOne`)
- One-to-Many (`@OneToMany`) and Many-to-One (`@ManyToOne`)
- Many-to-Many (`@ManyToMany`)

### 1. One-to-One Relationship (`@OneToOne`)

A one-to-one relationship exists when a record in one table is associated with exactly one record in another table.

**Example: Employee and Address**

```java
import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL) //note for myself  @OneToOne will do or any relationship
    @JoinColumn(name = "address_id")
    private Address address;

    // Getters and Setters
}

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String city;

    // Getters and Setters
}
```

### 2. One-to-Many and Many-to-One Relationships

A One-to-Many relationship implies that one record in a parent entity is related to multiple child records. A Many-to-One relationship implies that multiple child records are related to one parent.

**Example: Department and Employee**

```java
import javax.persistence.*;
import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Employee> employees;

    // Getters and Setters
}

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // Getters and Setters
}
```

### 3. Many-to-Many Relationship (`@ManyToMany`)

A many-to-many relationship exists when multiple records in one table are associated with multiple records in another table.

**Example: Student and Course**

```java
import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;

    // Getters and Setters
}

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    // Getters and Setters
}
```

## JPQL and Criteria Queries

### JPQL (Java Persistence Query Language)

JPQL is object-oriented and operates on entities instead of tables.

**Example:**

```java
List<Employee> employees = entityManager
    .createQuery("SELECT e FROM Employee e", Employee.class)
    .getResultList();
```

### Criteria Queries (Type-Safe)

```java
CriteriaBuilder cb = entityManager.getCriteriaBuilder();
CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
Root<Employee> root = cq.from(Employee.class);
cq.select(root);

List<Employee> employees = entityManager.createQuery(cq).getResultList();
```

## Lazy and Eager Loading

**Explanation:**

- **Lazy Loading**: Data is fetched only when accessed, improving performance.
- **Eager Loading**: Data is fetched immediately, even if not accessed.

**Example:**

```java
@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
private List<Employee> employees;
```

Change to eager loading by setting `FetchType.EAGER`.