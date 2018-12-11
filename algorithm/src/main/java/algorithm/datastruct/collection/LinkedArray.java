package algorithm.datastruct.collection;

public class LinkedArray<T> extends LinkedList<T> {
    public void add(T t){
        appendEnd(t);
    }

    public T get(int index){
        return super.get(index);
    }

    public T remove(int index){
        return super.remove(index);
    }
}
