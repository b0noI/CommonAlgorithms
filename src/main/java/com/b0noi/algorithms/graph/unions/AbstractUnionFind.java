package com.b0noi.algorithms.graph.unions;


import java.util.*;

abstract class AbstractUnionFind<T> implements IUnionFind<T> {

    protected Map<T, Integer>   elementsIndex   = new HashMap<>();

    protected List<Integer>     connections     = new ArrayList<>();

    @Override
    public synchronized void add(final T p) {
        elementsIndex.put(p, connections.size());
        connections.add(connections.size());
    }

    @Override
    public Set<T> elements() {
        return elementsIndex.keySet();
    }

}
