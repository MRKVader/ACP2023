package week1.data_structure.tree;

import java.util.*;

public class MTreeMap<K, V> implements Map<K, V> {

    public static final int DEFAULT_TABLE_SIZE = 16;
    private int size;

    private MNode<K, V>[] table = new MNode[DEFAULT_TABLE_SIZE];

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        int hash = Math.abs(key.hashCode());
        int position = hash % table.length;

        if (table[position] == null) {
            table[position] = new MNode<K, V>(key, value, null);
        } else {
            MNode<K, V> iter = table[position];
            do {
                if (iter.key.equals(key)) {
                    V oldValue = iter.value;
                    iter.value = value;
                    return oldValue;
                }
                iter = iter.next;
            }
            while (iter.next != null);
            iter.next = new MNode<K, V>(key, value, null);
        }
        size++;
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        Set<K> keys = new HashSet<K>();

        Iterator<MNode<K,V>> iterator = new MHashMapIterator();

        while (iterator.hasNext()){
            keys.add(iterator.next().key);
        }

        return keys;
    }

    @Override
    public Collection values() {
        Collection<V> values = new HashSet<V>();

        Iterator<MNode<K,V>> iterator = new MHashMapIterator();

        while (iterator.hasNext()){
            values.add(iterator.next().value);
        }

        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K,V>> entrySet = new HashSet<Entry<K, V>>();

        Iterator<MNode<K,V>> iterator = new MHashMapIterator();

        while (iterator.hasNext()){
            entrySet.add(iterator.next());
        }

        return null;
    }

    private class MHashMapIterator implements Iterator<MNode<K, V>> {

        int currentIndex;
        MNode<K, V> currNode;

        public MHashMapIterator() {
            firstFoundNotNull();
        }

        private void firstFoundNotNull() {
            for (; currentIndex < table.length && table[currentIndex] != null; currentIndex++) {
            }

            currNode = currentIndex < table.length ? table[currentIndex] : null;
        }

        @Override
        public boolean hasNext() {
            return currNode != null;
        }

        @Override
        public MNode<K, V> next() {
            MNode<K, V> ret = currNode;

            if (currNode.next != null) {
                currNode = currNode.next;
            } else {
                firstFoundNotNull();
            }
            return null;
        }
    }
}
