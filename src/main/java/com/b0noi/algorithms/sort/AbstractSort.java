package com.b0noi.algorithms.sort;


import java.util.Collection;
import java.util.List;

abstract class AbstractSort implements ISort {

    protected static <T extends Comparable<T>>boolean lower(final T left, final T right) {
        return left.compareTo(right) < 0;
    }

    protected static <T extends Comparable<T>>boolean greater(final T left, final T right) {
        return left.compareTo(right) > 0;
    }

    protected static <T extends Comparable<T>>boolean eq(final T left, final T right) {
        return left.compareTo(right) == 0;
    }

    protected static <T>void swap(final List<T> elements, final int from, final int to) {
        final T element = elements.get(from);
        elements.set(from, elements.get(to));
        elements.set(to, element);
    }

}
