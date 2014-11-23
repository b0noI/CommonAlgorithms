package com.b0noi.algorithms.sort;

import java.util.List;

public class InsertionSort extends AbstractSort {

    @Override
    public <T extends Comparable<T>> void sort(final List<T> elements) {
        for (int i = 0; i < elements.size(); i++) {
            final int minIndex = InsertionSort.minimumIndex(i, elements.get(i), elements);
            if (minIndex != i) {
                AbstractSort.swap(elements, i, minIndex);
            }
        }
    }

    private static <T extends Comparable<T>>int minimumIndex(final int index, final T currentMinElement, final List<T> elements) {
        try {

            if (index == elements.size()) return index;

            final T newMinElement =
                    AbstractSort.lower(elements.get(index), currentMinElement) ?
                            elements.get(index) :
                            currentMinElement;
            return minimumIndex(index + 1, newMinElement, elements);
        } catch (StackOverflowError e) {
            throw e;
        }
    }

}
