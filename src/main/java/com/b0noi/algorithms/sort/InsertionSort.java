package com.b0noi.algorithms.sort;

import java.util.List;

public class InsertionSort extends AbstractSort {

    @Override
    public <T extends Comparable<T>> void sort(final List<T> elements) {
        for (int i = 0; i < elements.size(); i++) {
            final int minIndex = InsertionSort.minimumIndex(i, elements);
            if (minIndex != i) {
                AbstractSort.swap(elements, i, minIndex);
            }
        }
    }

    private static <T extends Comparable<T>>int minimumIndex(final int from, final List<T> elements) {
        int minElementIndex = from;
        for (int i = from + 1; i < elements.size(); i++) {
            if (AbstractSort.lower(elements.get(i), elements.get(minElementIndex))) {
                minElementIndex = i;
            }
        }
        return minElementIndex;
    }

}
