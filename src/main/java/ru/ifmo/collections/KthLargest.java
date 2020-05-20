package ru.ifmo.collections;

import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {
    private List<Integer> elements = new LinkedList<>();
    private int k;
    public KthLargest(int k, int[] numbers) {
        for (int i: numbers) {
            elements.add(i);
        }
        this.k = k;
    }

    public int add(int val) {
        elements.add(val);
        elements.sort(Collections.reverseOrder());
        return elements.get(k - 1);
    }
}