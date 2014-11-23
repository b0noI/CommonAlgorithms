package com.b0noi.algorithms.sort;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class MergeSort extends AbstractSort {

    private static final ForkJoinPool FORK_JOIN_POOL = new ForkJoinPool();

    @Override
    public <T extends Comparable<T>> void sort(final List<T> elements) {
        final RecursiveMergeTask<T> task = new RecursiveMergeTask<T>(0, elements.size(), elements);
        FORK_JOIN_POOL.submit(task);
        task.join();
    }

}

class RecursiveMergeTask<T extends Comparable<T>> extends RecursiveAction {

    private final int startIndex;

    private final int endIndex;

    private final List<T> elements;

    RecursiveMergeTask(final int startIndex,
                       final int endIndex,
                       final List<T> elements) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.elements = elements;
    }

    @Override
    protected void compute() {
        if (endIndex - startIndex == 1) return;

        final int midl = (int)((double)(endIndex + startIndex) / 2.);
        final RecursiveMergeTask<T> leftTask = new RecursiveMergeTask<T>(startIndex, midl, elements);
        final RecursiveMergeTask<T> rightTask = new RecursiveMergeTask<T>(midl, endIndex, elements);
        leftTask.fork();
        rightTask.fork();
        leftTask.join();
        rightTask.join();
        final List<T> result = new ArrayList<>(endIndex - startIndex);
        int i = startIndex, j = midl;
        for (int k = 0; k < endIndex - startIndex; k++) {
            result.add(null);
            if (i >= midl) result.set(k, elements.get(j++));
            else if (j >= endIndex) result.set(k, elements.get(i++));
            else if (AbstractSort.lower(elements.get(j), elements.get(i))) result.set(k, elements.get(j++));
            else result.set(k, elements.get(i++));
        }
        for (i = 0; i < result.size(); i++) {
            elements.set(i + startIndex, result.get(i));
        }
    }

}
