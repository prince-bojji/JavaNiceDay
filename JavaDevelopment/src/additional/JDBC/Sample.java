package additional.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sample {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "sampledb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "johanten20";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // Create the database if it doesn't exist
            createDatabaseIfNotExists(connection);

            // Connect to the newly created database
            String dbConnectionURL = DB_URL + DB_NAME;
            try (Connection dbConnection = DriverManager.getConnection(dbConnectionURL, DB_USER, DB_PASSWORD)) {
                System.out.println("Connected to the database.");

                // Ensure the table is created
                createTableIfNotExists(dbConnection);

                // Perform CRUD operations
                insertProduct(dbConnection, "Laptop", 59999.99);
                insertProduct(dbConnection, "Smartphone", 29999.49);

                readProducts(dbConnection);

                updateProductPrice(dbConnection, 1, 49999.99);

                deleteProduct(dbConnection, 2);

                System.out.println("\nFinal Product List:");
                readProducts(dbConnection);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createDatabaseIfNotExists(Connection connection) throws SQLException {
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS " + DB_NAME;
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createDatabaseSQL);
            System.out.println("Database '" + DB_NAME + "' created or already exists.");
        }
    }

    private static void createTableIfNotExists(Connection connection) throws SQLException {
        String createTableSQL = """
                CREATE TABLE IF NOT EXISTS Product (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(50) NOT NULL,
                    price DOUBLE NOT NULL
                )
                """;
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableSQL);
            System.out.println("Table 'Product' created or already exists.");
        }
    }

    private static void insertProduct(Connection connection, String name, double price) throws SQLException {
        String insertSQL = "INSERT INTO Product (name, price) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, price);
            int rowsInserted = preparedStatement.executeUpdate();
            System.out.println("Inserted " + rowsInserted + " row(s) successfully.");
        }
    }

    private static void readProducts(Connection connection) throws SQLException {
        String selectSQL = "SELECT * FROM Product";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(selectSQL)) {
            System.out.println("Product List:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                System.out.printf("ID: %d, Name: %s, Price: %.2f%n", id, name, price);
            }
        }
    }

    private static void updateProductPrice(Connection connection, int id, double newPrice) throws SQLException {
        String updateSQL = "UPDATE Product SET price = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
            preparedStatement.setDouble(1, newPrice);
            preparedStatement.setInt(2, id);
            int rowsUpdated = preparedStatement.executeUpdate();
            System.out.println("Updated " + rowsUpdated + " row(s) successfully.");
        }
    }

    private static void deleteProduct(Connection connection, int id) throws SQLException {
        String deleteSQL = "DELETE FROM Product WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setInt(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();
            System.out.println("Deleted " + rowsDeleted + " row(s) successfully.");
        }
    }
}
