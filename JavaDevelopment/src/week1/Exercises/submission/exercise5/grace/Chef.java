package week1.Exercises.submission.exercise5.grace;

public class Chef extends Thread {
    String name;

    public Chef(String name) {
        this.name = name;
    }

    public synchronized void preparePasta() {
        System.out.println("Chef " + name + " is preparing pasta.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Chef " + name + "'s Pasta is now ready to serve.");
    }

    public synchronized void preparePizza() {
        System.out.println("Chef " + name + " is preparing pizza.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Chef " + name + "'s Pizza is now ready to serve.");
    }

    @Override
    public void run() {
        preparePasta();
        preparePizza();
    }
}
