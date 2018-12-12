package algorithm.datastruct.collection;

public class LinkedStack<T> {
    LinkedList<T> list = new LinkedList<>();
    public void push(T t){
        list.appendFront(t);
    }

    public T pop(){
        return list.removeFront();
    }
}
