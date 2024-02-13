package week1.Generics;

public class GenericsList<T> {
    private T content;

    public void add(T item) {
        this.content = item;
    }

    public T get() {
        return content;
    }
}
