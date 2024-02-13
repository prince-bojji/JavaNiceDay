package week1.Concurrency_Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingExecutorService  {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Task("Task 1"));
        executorService.execute(new Task("Task 2"));
        executorService.shutdown();
    }
}
