package week1.exercises.submission.exercise5.grace;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Chef chef1 = new Chef("George");
        Chef chef2 = new Chef("Callie");

        executorService.submit(chef1);
        executorService.submit(chef2);

        executorService.shutdown();
    }
}
