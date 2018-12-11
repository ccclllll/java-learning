package algorithm.datastruct.collection;

public class LinkedQueue<T> extends LinkedList<T> {
    public void enterQueue(T t) {
        this.appendEnd(t);
    }

    public T peekQueue() {
        return removeFront();
    }
}
