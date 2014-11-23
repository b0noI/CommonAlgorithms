package com.b0noi.algorithms.sort;

import java.util.Collection;
import java.util.List;


public class InsertionSort extends AbstractSort {

    private static final int DEFAULT_STEP = 1;

    private final int step;

    public InsertionSort(final int step) {
        this.step = step;
    }

    public InsertionSort() {
        this(DEFAULT_STEP);
    }

    @Override
    public <T extends Comparable<T>> void sort(final List<T> elements) {
        for (int i = 0; i < elements.size(); i += step) {
            for (int j = i; j > 0; j -= step) {

                if (AbstractSort.lower(elements.get(j), elements.get(j - step))) {
                    AbstractSort.swap(elements, j - step, j);
                } else {
                    break;
                }

            }
        }
    }

}
