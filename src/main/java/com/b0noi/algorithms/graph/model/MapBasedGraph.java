package com.b0noi.algorithms.graph.model;

import java.util.*;


public class MapBasedGraph<T> implements IGraph<T> {

    private final Map<T, List<T>> edges = new HashMap<>();

    @Override
    public void addNode(final T node) {
        edges.merge(node, new ArrayList<>(), (l1, l2) -> {
            l1.addAll(l2);
            return l1;
        });
    }

    @Override
    public synchronized void addEdge(final T from, final T to) {
        final List<T> edges1 =  edges.get(from);
        final List<T> edges2 =  edges.get(to);
        edges1.add(to);
        edges2.add(from);
    }

    @Override
    public synchronized Iterable<T> adj(final T node) {
        return edges.get(node);
    }

}
