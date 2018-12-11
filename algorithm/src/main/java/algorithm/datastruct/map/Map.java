package algorithm.datastruct.map;

public interface Map<K,V> {
    V put(K key,V value);
    V get(K key);
    void clear();
    V remove(K key);
}
