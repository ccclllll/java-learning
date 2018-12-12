package algorithm.datastruct.map;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class HashMap<K, V> extends AbstractMap<K, V> {
    private final int SIZE = 997;
    private LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];
    private Set<MapEntry<K, V>> entrySet = new HashSet<>();
    private Set<K> keySet = new HashSet<>();

    class Entry<K, V> implements MapEntry<K, V> {
        private K key;
        private V value;

        Entry(K k, V v) {
            this.key = k;
            this.value = v;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public void setValue(V v) {
            this.value = v;
        }
    }

    @Override
    public V put(K key, V value) {
        V oldValue;
        int index = Math.abs(key.hashCode()) % SIZE;
        LinkedList<MapEntry<K, V>> entries = buckets[index];
        if (entries == null) {
            Entry<K, V> entry = new Entry<>(key, value);
            buckets[index] = new LinkedList<>();
            buckets[index].add(entry);
            entrySet.add(entry);
            keySet.add(entry.key);
        } else {
            Iterator<MapEntry<K, V>> iterator = entries.iterator();
            while (iterator.hasNext()) {
                MapEntry<K, V> entry = iterator.next();
                if (entry.getKey().equals(key)) {
                     oldValue = entry.getValue();
                    entry.setValue(value);
                    return oldValue;
                }
            }

            MapEntry<K, V> entry = new Entry<>(key, value);
            entries.add(entry);
            entrySet.add(entry);
            keySet.add(entry.getKey());
        }
        return null;
    }

    @Override
    public V get(K key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        LinkedList<MapEntry<K, V>> entries = buckets[index];
        if (entries == null)
            return null;
        Iterator<MapEntry<K, V>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            MapEntry<K, V> entry = iterator.next();
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public void clear() {
        this.buckets = new LinkedList[SIZE];
    }

    @Override
    public V remove(K key) {
        int index = this.computeIndex(key);
        LinkedList<MapEntry<K, V>> entries = buckets[index];
        if (entries == null)
            return null;
        Iterator<MapEntry<K, V>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            MapEntry<K, V> entry = iterator.next();
            if (entry.getKey().equals(key)) {
                iterator.remove();

                return entry.getValue();
            }
        }
        return null;
    }


    public Set<MapEntry<K, V>> entrySet() {
        return this.entrySet;
    }

    public Set<K> krySet() {
        return this.keySet;
    }
    private int computeIndex(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }
}
