import java.io.*;
import java.util.*;

public class FileStreamExample2 {

    private static final String FILE_NAME = "output.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Record");
            System.out.println("2. Read Record by ID");
            System.out.println("3. Read All Records");
            System.out.println("4. Update Record by ID");
            System.out.println("5. Delete Record by ID");
            System.out.println("6. Delete All Records");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1 -> addRecord(scanner);
                case 2 -> readRecordById(scanner);
                case 3 -> readAllRecords();
                case 4 -> updateRecordById(scanner);
                case 5 -> deleteRecordById(scanner);
                case 6 -> deleteAllRecords();
                case 7 -> {
                    System.out.println("Exiting the application...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    /**
     * Add a new record to the file.
     */
    private static void addRecord(Scanner scanner) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Age: ");
            int age = scanner.nextInt();

            writer.write(id + "\t" + name + "\t" + age);
            writer.newLine();
            System.out.println("Record added successfully.");
        } catch (IOException e) {
            System.out.println("Error while adding record: " + e.getMessage());
        }
    }

    /**
     * Read a record by its ID from the file.
     */
    private static void readRecordById(Scanner scanner) {
        System.out.print("Enter ID to read: ");
        int idToRead = scanner.nextInt();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            boolean recordFound = false;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\t");
                if (Integer.parseInt(data[0]) == idToRead) {
                    System.out.println("Record: " + line);
                    recordFound = true;
                    break;
                }
            }

            if (!recordFound) {
                System.out.println("No record found with ID: " + idToRead);
            }
        } catch (IOException e) {
            System.out.println("Error while reading record: " + e.getMessage());
        }
    }

    /**
     * Read all records from the file.
     */
    private static void readAllRecords() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\nRecords in " + FILE_NAME + ":");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error while reading all records: " + e.getMessage());
        }
    }

    /**
     * Update a record by its ID in the file.
     */
    private static void updateRecordById(Scanner scanner) {
        System.out.print("Enter ID to update: ");
        int idToUpdate = scanner.nextInt();
        scanner.nextLine(); // consume newline

        List<String> updatedRecords = new ArrayList<>();
        boolean recordUpdated = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\t");
                int id = Integer.parseInt(data[0]);

                if (id == idToUpdate) {
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    updatedRecords.add(id + "\t" + newName + "\t" + newAge);
                    recordUpdated = true;
                } else {
                    updatedRecords.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error while updating record: " + e.getMessage());
        }

        if (recordUpdated) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for (String record : updatedRecords) {
                    writer.write(record);
                    writer.newLine();
                }
                System.out.println("Record updated successfully.");
            } catch (IOException e) {
                System.out.println("Error while saving updated records: " + e.getMessage());
            }
        } else {
            System.out.println("No record found with ID: " + idToUpdate);
        }
    }

    /**
     * Delete a record by its ID from the file.
     */
    private static void deleteRecordById(Scanner scanner) {
        System.out.print("Enter ID to delete: ");
        int idToDelete = scanner.nextInt();

        List<String> remainingRecords = new ArrayList<>();
        boolean recordDeleted = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\t");
                int id = Integer.parseInt(data[0]);

                if (id == idToDelete) {
                    recordDeleted = true;
                } else {
                    remainingRecords.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error while deleting record: " + e.getMessage());
        }

        if (recordDeleted) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for (String record : remainingRecords) {
                    writer.write(record);
                    writer.newLine();
                }
                System.out.println("Record deleted successfully.");
            } catch (IOException e) {
                System.out.println("Error while saving remaining records: " + e.getMessage());
            }
        } else {
            System.out.println("No record found with ID: " + idToDelete);
        }
    }

    /**
     * Delete all records from the file.
     */
    private static void deleteAllRecords() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write("");
            System.out.println("All records deleted successfully.");
        } catch (IOException e) {
            System.out.println("Error while deleting all records: " + e.getMessage());
        }
    }
}

