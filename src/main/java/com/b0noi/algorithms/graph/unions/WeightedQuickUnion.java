package com.b0noi.algorithms.graph.unions;


import java.util.ArrayList;
import java.util.List;

public class WeightedQuickUnion<T> extends QuickUnion<T> {

    private final List<Integer> treeSize = new ArrayList<>();

    @Override
    public synchronized void add(final T p) {
        treeSize.add(1);
        super.add(p);
    }

    @Override
    public synchronized void union(T p, T q) {
        final Integer index1 = elementsIndex.get(p);
        final Integer index2 = elementsIndex.get(q);
        final Integer root1 = findRecursive(index1);
        final Integer root2 = findRecursive(index2);
        if (treeSize.get(root1) > treeSize.get(root2)) {
            connections.set(root2, root1);
            treeSize.set(root2, treeSize.get(root1) + treeSize.get(root2));
        } else {
            connections.set(root1, root2);
            treeSize.set(root1, treeSize.get(root1) + treeSize.get(root2));
        }
    }

}
