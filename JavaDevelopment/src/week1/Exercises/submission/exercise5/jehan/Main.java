package week1.exercises.submission.exercise5.jehan;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Create 2 chefs
        Chef chef1 = new Chef("Chef Jehan");
        Chef chef2 = new Chef("Chef Mary");

        // Submitting task to the executor
        executorService.submit(chef1);
        executorService.submit(chef2);

        // Shutting down the executor
        executorService.shutdown();
    }
}
