package algorithm.datastruct.collection;

public abstract class List<T> {
    protected int size = 0;

    
    protected abstract T get(int index);

    protected abstract T getFirst();

    protected abstract T getLast();

    protected abstract void insert(int index, T t);

    protected abstract void appendFront(T t);

    protected abstract void appendEnd(T t);

    public int size() {
        return this.size;
    }

    protected abstract T remove(int index);

    public boolean isEmpty() {
        return this.size == 0;
    }

    protected abstract T removeEnd();

    protected abstract T removeFront();
}
