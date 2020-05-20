package ru.ifmo.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {
    private HashSet<Integer> unique = new LinkedHashSet<>();
    private HashSet<Integer> nonunique = new LinkedHashSet<>();
    public FirstUnique(int[] numbers) {
        for (int i : numbers) {
            add(i);
        }
    }

    public int showFirstUnique() {
        if (unique.isEmpty()) {
            return -1;
        }
        else {
            return unique.iterator().next();
        }
    }

    public void add(int value) {
        if(nonunique.contains(value)) {
            return;
        }
        else if (unique.contains(value)) {
            unique.remove(value);
            nonunique.add(value);
        }
        else {
            unique.add(value);
        }
    }
}
