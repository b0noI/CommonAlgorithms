package com.b0noi.algorithms.sort;


import java.util.Collection;
import java.util.List;

public interface ISort {

    public<T extends Comparable<T>> void sort(final List<T> elements);

}
