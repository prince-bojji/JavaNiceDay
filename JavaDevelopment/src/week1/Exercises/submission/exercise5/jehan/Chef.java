package week1.exercises.submission.exercise5.jehan;

public class Chef implements Runnable{
    private String chef;

    public  Chef(String chef) {
        this.chef = chef;
    }

    public void preparePasta(){
        synchronized (this) {
            System.out.println("Your order pasta is now on processing... -"+chef);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(chef + " has finished preparing your pasta.");
    }

    public void preparePizza(){
        synchronized (this) {
            System.out.println("Your order pizza is now on processing... -"+chef);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(chef + " has finished preparing your pizza.");
    }

    @Override  
    public void run(){
        preparePasta();
        preparePizza();
    }
}
