# Input/Output File Streams and File Manipulation in Java

Java provides `InputStream` and `OutputStream` classes for handling byte streams, as well as `Reader` and `Writer` classes for handling character streams. These classes are essential for reading and writing data to files.

## File Streams

### Reading from a File using FileInputStream

The `FileInputStream` class reads raw bytes from a file.

```java
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamExample {
    public static void main(String[] args) {
        try (FileInputStream inputStream = new FileInputStream("example.txt")) {
            int content;
            while ((content = inputStream.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Writing to a File using FileOutputStream

The `FileOutputStream` class writes raw bytes to a file.

```java
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamExample {
    public static void main(String[] args) {
        String data = "Hello, FileOutputStream!";
        try (FileOutputStream outputStream = new FileOutputStream("output.txt")) {
            outputStream.write(data.getBytes());
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## Character Streams

### Reading from a File using FileReader

The `FileReader` class reads characters from a file.

```java
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("example.txt")) {
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Writing to a File using FileWriter

The `FileWriter` class writes characters to a file.

```java
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) {
        String data = "Hello, FileWriter!";
        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write(data);
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## File Manipulation

### Checking if a File Exists

```java
import java.io.File;

public class FileExistsExample {
    public static void main(String[] args) {
        File file = new File("example.txt");
        if (file.exists()) {
            System.out.println("File exists: " + file.getAbsolutePath());
        } else {
            System.out.println("File does not exist.");
        }
    }
}
```

### Creating a New File

```java
import java.io.File;
import java.io.IOException;

public class CreateFileExample {
    public static void main(String[] args) {
        File file = new File("newFile.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Deleting a File

```java
import java.io.File;

public class DeleteFileExample {
    public static void main(String[] args) {
        File file = new File("output.txt");
        if (file.delete()) {
            System.out.println("File deleted: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}
```

## Directory Manipulation

### Creating a Directory

```java
import java.io.File;

public class CreateDirectoryExample {
    public static void main(String[] args) {
        File directory = new File("myDirectory");
        if (directory.mkdir()) {
            System.out.println("Directory created: " + directory.getName());
        } else {
            System.out.println("Failed to create directory.");
        }
    }
}
```

### Listing Files in a Directory

```java
import java.io.File;

public class ListFilesExample {
    public static void main(String[] args) {
        File directory = new File(".");
        String[] files = directory.list();
        if (files != null) {
            for (String fileName : files) {
                System.out.println(fileName);
            }
        } else {
            System.out.println("No files found.");
        }
    }
}
```
