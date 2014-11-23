package com.b0noi.algorithms.graph.unions;


import java.util.*;
import java.util.stream.IntStream;

public class QuickFind<T> implements IUnionFind<T> {

    private Map<T, Integer> elementsIndex = new HashMap<>();

    private List<Integer> connections = new ArrayList<>();

    @Override
    public synchronized void union(T p, T q) {
        final Integer id1 = elementsIndex.get(p);
        final Integer id2 = elementsIndex.get(q);
        IntStream.range(0, connections.size()).forEach(index -> {
            if (connections.get(index).equals(id1)) {
                connections.set(index, id2);
            }
        });
    }

    @Override
    public synchronized boolean connect(T p, T q) {
        final int id1 = elementsIndex.get(p);
        final int id2 = elementsIndex.get(q);
        return connections.get(id1).equals(connections.get(id2));
    }

    @Override
    public synchronized int find(T p) {
        final int id1 = elementsIndex.get(p);
        return connections.get(id1);
    }

    @Override
    public synchronized int count() {
        return (int)connections.stream().distinct().count();
    }

    @Override
    public synchronized void add(final T p) {
        elementsIndex.put(p, connections.size());
        connections.add(connections.size());
    }

}
