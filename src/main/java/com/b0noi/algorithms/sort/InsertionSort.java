package com.b0noi.algorithms.sort;

import java.util.Collection;
import java.util.List;


public class InsertionSort extends AbstractSort {

    @Override
    public <T extends Comparable<T>> void sort(final List<T> elements) {
        for (int i = 0; i < elements.size(); i++) {
            for (int j = i; j > 0; j--) {

                if (AbstractSort.lower(elements.get(j), elements.get(j - 1))) {
                    AbstractSort.swap(elements, j - 1, j);
                } else {
                    break;
                }

            }
        }
    }

}
