# JDBC

The JDBC (Java Database Connectivity) API enables Java applications to interact with relational databases. It provides methods for connecting to a database, executing SQL queries, and processing the results. JDBC abstracts the complexities of database communication, offering a standardized approach for database operations.

## Key Terminologies

### JDBC Driver

A software component that acts as a bridge between the Java application and the database. Examples: MySQL Connector/J, Oracle JDBC Driver.

### Connection

Represents a session between the Java application and the database. It's essential for sending SQL commands.

**Example:**

```java
Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
```

### DriverManager

A class that manages JDBC drivers and establishes connections to the database.

**Example:**

```java
Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname", "user", "password");
```

### Statement

Used to execute simple SQL queries. Suitable for static SQL commands without parameters.

**Example:**

```java
Statement statement = connection.createStatement();
ResultSet rs = statement.executeQuery("SELECT * FROM employees");
```

### PreparedStatement

Used for executing precompiled parameterized SQL queries. Prevents SQL injection and improves performance.

**Example:**

```java
String query = "INSERT INTO employees (name, age) VALUES (?, ?)";
PreparedStatement pstmt = connection.prepareStatement(query);
pstmt.setString(1, "Alice");
pstmt.setInt(2, 30);
pstmt.executeUpdate();
```

### ResultSet

Represents the result of a database query and allows iteration through the returned rows.

**Example:**

```java
ResultSet rs = statement.executeQuery("SELECT * FROM products");
while (rs.next()) {
    System.out.println(rs.getString("name"));
}
```

### Transactions

A series of database operations executed as a single unit to ensure consistency. Transactions follow ACID properties.

**Example (Manual Transaction Management):**

```java
connection.setAutoCommit(false);
try {
    statement.executeUpdate("INSERT INTO orders VALUES (1, 'Laptop')");
    connection.commit();
} catch (SQLException e) {
    connection.rollback();
}
```

#### Commit and Rollback

- `commit()` saves all changes made during the transaction.
- `rollback()` undoes changes if an error occurs.

### Batch Processing

Executing multiple SQL commands as a batch to improve performance.

**Example:**

```java
PreparedStatement pstmt = connection.prepareStatement("INSERT INTO students (name, age) VALUES (?, ?)");
pstmt.setString(1, "John");
pstmt.setInt(2, 22);
pstmt.addBatch();
pstmt.executeBatch();
```

### Metadata

Provides information about database schema and result sets using `DatabaseMetaData` and `ResultSetMetaData`.
