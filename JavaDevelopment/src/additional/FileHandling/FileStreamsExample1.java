
import java.io.*;
import java.util.*;

/**
 * File Manipulation Example using FileOutputStream and FileInputStream.
 * Supports CRUD operations on a text file.
 */
public class FileStreamsExample1 {

    private static final String FILE_NAME = "output.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Record");
            System.out.println("2. Read Record by ID");
            System.out.println("3. Read All Records");
            System.out.println("4. Update Record by ID");
            System.out.println("5. Delete Record by ID");
            System.out.println("6. Delete All Records");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1 ->
                    addRecord(scanner);
                case 2 ->
                    readRecordById(scanner);
                case 3 ->
                    readAllRecords();
                case 4 ->
                    updateRecordById(scanner);
                case 5 ->
                    deleteRecordById(scanner);
                case 6 ->
                    deleteAllRecords();
                case 7 ->
                    running = false;
                default ->
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void addRecord(Scanner scanner) {
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME, true)) {
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Age: ");
            int age = scanner.nextInt();

            String record = id + "\t" + name + "\t" + age + System.lineSeparator();
            fos.write(record.getBytes());
            System.out.println("Record added successfully.");
        } catch (IOException e) {
            System.out.println("Error while adding record: " + e.getMessage());
        }
    }

    private static void readRecordById(Scanner scanner) {
        System.out.print("Enter ID to search: ");
        int idToFind = scanner.nextInt();

        try (FileInputStream fis = new FileInputStream(FILE_NAME); Scanner fileScanner = new Scanner(fis)) {

            boolean found = false;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split("\t");
                if (parts.length == 3 && Integer.parseInt(parts[0]) == idToFind) {
                    System.out.println("Record Found: " + line);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Record not found.");
            }

        } catch (IOException e) {
            System.out.println("Error while reading record: " + e.getMessage());
        }
    }

    private static void readAllRecords() {
        try (FileInputStream fis = new FileInputStream(FILE_NAME)) {
            int content;
            System.out.println("\nRecords in " + FILE_NAME + ":");
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            System.out.println("Error while reading records: " + e.getMessage());
        }
    }

    private static void updateRecordById(Scanner scanner) {
        System.out.print("Enter ID to update: ");
        int idToUpdate = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        System.out.print("Enter new Name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new Age: ");
        int newAge = scanner.nextInt();

        List<String> records = new ArrayList<>();
        boolean updated = false;

        try (FileInputStream fis = new FileInputStream(FILE_NAME); Scanner fileScanner = new Scanner(fis)) {

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split("\t");
                if (parts.length == 3 && Integer.parseInt(parts[0]) == idToUpdate) {
                    line = idToUpdate + "\t" + newName + "\t" + newAge;
                    updated = true;
                }
                records.add(line);
            }

        } catch (IOException e) {
            System.out.println("Error while reading records: " + e.getMessage());
        }

        if (updated) {
            try (FileOutputStream fos = new FileOutputStream(FILE_NAME)) {
                for (String record : records) {
                    fos.write((record + System.lineSeparator()).getBytes());
                }
                System.out.println("Record updated successfully.");
            } catch (IOException e) {
                System.out.println("Error while updating record: " + e.getMessage());
            }
        } else {
            System.out.println("Record not found.");
        }
    }

    private static void deleteRecordById(Scanner scanner) {
        System.out.print("Enter ID to delete: ");
        int idToDelete = scanner.nextInt();

        List<String> records = new ArrayList<>();
        boolean deleted = false;

        try (FileInputStream fis = new FileInputStream(FILE_NAME); Scanner fileScanner = new Scanner(fis)) {

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split("\t");
                if (parts.length == 3 && Integer.parseInt(parts[0]) == idToDelete) {
                    deleted = true;
                } else {
                    records.add(line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error while reading records: " + e.getMessage());
        }

        if (deleted) {
            try (FileOutputStream fos = new FileOutputStream(FILE_NAME)) {
                for (String record : records) {
                    fos.write((record + System.lineSeparator()).getBytes());
                }
                System.out.println("Record deleted successfully.");
            } catch (IOException e) {
                System.out.println("Error while deleting record: " + e.getMessage());
            }
        } else {
            System.out.println("Record not found.");
        }
    }

    private static void deleteAllRecords() {
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME)) {
            // Writing nothing to the file effectively clears it
            System.out.println("All records deleted successfully.");
        } catch (IOException e) {
            System.out.println("Error while deleting all records: " + e.getMessage());
        }
    }
}
