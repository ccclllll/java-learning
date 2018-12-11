package algorithm.datastruct.map;

public interface MapEntry<K,V> {
    V getValue();
    K getKey();
    void setValue(V v);
}
