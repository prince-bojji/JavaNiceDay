package week1.exercises.submission.exercise3.grace;

public class CustomCollection<Thing> {
    Thing[] collection;
    int size;

    @SuppressWarnings("unchecked")
    public CustomCollection(int size) {
        collection = (Thing[]) new Object[size];
        this.size = size;
    }

    public void add(Thing newElement) {
        if (checkMax() == true) {
            return;
        }

        int index = 0;
        for (Thing x : collection) {
            if (x == null) {
                collection[index] = newElement;
                break;
            }
            index++;
        }
    }

    public void remove(int index) {
        while (index != collection.length - 1) {
            collection[index] = collection[index + 1];
            index++;
        }

        collection[collection.length - 1] = null;
    }

    public Thing get(int index) {
        return collection[index];
    }

    public boolean checkMax() {
        return collection[collection.length - 1] != null;
    }

}
