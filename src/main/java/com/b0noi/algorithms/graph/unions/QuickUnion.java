package com.b0noi.algorithms.graph.unions;


public class QuickUnion<T> extends AbstractUnionFind<T> {

    @Override
    public synchronized void union(final T p, final T q) {
        final Integer index1 = elementsIndex.get(p);
        final Integer index2 = elementsIndex.get(q);
        final Integer root1 = findRecursive(index1);
        final Integer root2 = findRecursive(index2);
        connections.set(root1, root2);
    }

    @Override
    public synchronized boolean connect(final T p, final T q) {
        final Integer index1 = elementsIndex.get(p);
        final Integer index2 = elementsIndex.get(q);
        final Integer root1 = findRecursive(index1);
        final Integer root2 = findRecursive(index2);
        return root1.equals(root2);
    }

    @Override
    public synchronized int find(final T p) {
        final int index = elementsIndex.get(p);
        return findRecursive(index);
    }

    @Override
    public synchronized int count() {
        return (int)connections.stream().map(index -> findRecursive(index)).distinct().count();
    }

    protected int findRecursive(final Integer index) {
        if (!connections.get(index).equals(index)) {
            return findRecursive(connections.get(index));
        }
        return index;
    }

}
