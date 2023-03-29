package week1.data_structure.tree;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MTreeMap<K, V> implements Map<K, V> {

    public static final int DEFAULT_TABLE_SIZE = 16;

    private MyNode<K,V>[] table =  new MyNode[DEFAULT_TABLE_SIZE];

    @Override
    public int size() {
        return 0;
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

        if(table[position] == null){
            table[position] = new MyNode<K,V>(key, value, null);
        } else {
            table[position] = new MyNode<K,V>(key, value, table[position]);
        }

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
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
