package ru.ifmo.collections;

/**
 * Represents LRU cache with fixed maximum capacity.
 *
 * get() should return null if there is no value for a given key.
 * elements() should return number of elements in cache.
 *
 * This class should not have any other public methods.
 *
 * Implementing this cache in (almost) the same manner as it was implemented during the lecture will result in extra points.
 */
import java.util.HashMap;

public class LruCache<K, V> {
    private class Entry {
        K key;
        V value;
        Entry left;
        Entry right;
    }
    private HashMap<K, Entry> hashmap;
    private Entry begin, end;
    private int size;

    public LruCache(int capacity) {
        hashmap = new HashMap<K, Entry>();
        size = capacity;
    }

    public V get(K key) {
        if (hashmap.containsKey(key))
        {
            Entry entry = hashmap.get(key);
            removeNode(entry);
            addAtTop(entry);
            return entry.value;
        }
        return null;
    }

    public void put(K key, V value) {
        if (hashmap.containsKey(key))
        {
            Entry entry = hashmap.get(key);
            entry.value = value;
            removeNode(entry);
            addAtTop(entry);
        } else {
            Entry newnode = new Entry();
            newnode.left = null;
            newnode.right = null;
            newnode.value = value;
            newnode.key = key;
            if (hashmap.size() >= size)
            {
                hashmap.remove(end.key);
                removeNode(end);
                addAtTop(newnode);

            } else {
                addAtTop(newnode);
            }

            hashmap.put(key, newnode);
        }
    }
    private void addAtTop(Entry node) {
        node.right = begin;
        node.left = null;
        if (begin != null)
            begin.left = node;
        begin = node;
        if (end == null)
            end = begin;
    }

    private void removeNode(Entry node) {
        if (node.left != null) {
            node.left.right = node.right;
        } else {
            begin = node.right;
        }

        if (node.right != null) {
            node.right.left = node.left;
        } else {
            end = node.left;
        }
    }
    public int elements() {
        return hashmap.size();
    }
}