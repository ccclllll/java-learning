package algorithm.datastruct.collection;

public class LinkedQueue<T>{
    LinkedList<T> list = new LinkedList<>();
    public void enterQueue(T t) {
        list.appendEnd(t);
    }

    public T peekQueue() {
        return list.removeFront();
    }
}
