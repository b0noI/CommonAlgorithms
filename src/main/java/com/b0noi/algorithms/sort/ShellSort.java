package com.b0noi.algorithms.sort;

import java.util.List;

public class ShellSort extends AbstractSort {

    @Override
    public <T extends Comparable<T>> void sort(List<T> elements) {
        for (int i = (int)((double)elements.size() / 3.); i > 0; i--) {
            final ISort sortInstance = new InsertionSort(i);
            sortInstance.sort(elements);
        }
    }

}
