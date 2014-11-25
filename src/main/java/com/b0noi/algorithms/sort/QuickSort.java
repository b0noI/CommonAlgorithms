package com.b0noi.algorithms.sort;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;


public class QuickSort extends AbstractSort {

    private static final ForkJoinPool forkJoinPool = new ForkJoinPool();

    @Override
    public <T extends Comparable<T>> void sort(final List<T> elements) {
        sort(elements, 0, elements.size());
    }

    private <T extends Comparable<T>> void sort(final List<T> elements, final int start, final int end) {
        final RecursiveQuickSort<T> task = new RecursiveQuickSort<>(elements, start, end);
        forkJoinPool.submit(task);
        task.join();
    }

    private static class RecursiveQuickSort<T extends Comparable<T>> extends RecursiveAction {

        private final List<T> elements;

        private final int from;

        private final int to;

        private RecursiveQuickSort(final List<T> elements, final int from, final int to) {
            this.elements = elements;
            this.from = from;
            this.to = to;
        }

        @Override
        protected void compute() {
            if (to - from < 2) return;
            final T mid = elements.get(from);
            int i = from;
            int j = to - 1;
            while (i != j) {
                while ((AbstractSort.lower(elements.get(i), mid)
                        || AbstractSort.eq(elements.get(i), mid))
                        && i != j) i++;
                while (AbstractSort.greater(elements.get(j), mid)
                        && i != j) j--;
                if (i != j) AbstractSort.swap(elements, i, j);
            }
            if (AbstractSort.greater(elements.get(i), mid)) {
                AbstractSort.swap(elements, from, i - 1);
            } else {
                AbstractSort.swap(elements, from, i);
            }
            final RecursiveQuickSort<T> leftTask = new RecursiveQuickSort<>(elements, from, i);
            final RecursiveQuickSort<T> rightTask = new RecursiveQuickSort<>(elements, i, to);
            leftTask.fork();
            rightTask.fork();
            leftTask.join();
            rightTask.join();
        }

    }

}
