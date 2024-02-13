package week1.Concurrency_Multithreading;

public class UsingThread {
    public static void main(String[] args) {
        // Create and start two threads
        Thread thread1 = new Thread(new Task("Task 1"));
        Thread thread2 = new Thread(new Task("Task 2"));
        thread1.start();
        thread2.start();
    }
}

class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        // Task to be performed by the thread
        for (int i = 0; i < 5; i++) {
            System.out.println(name + " - Step " + i);
            try {
                Thread.sleep(1000); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

