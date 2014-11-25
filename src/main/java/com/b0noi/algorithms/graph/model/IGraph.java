package com.b0noi.algorithms.graph.model;


import java.util.Iterator;

public interface IGraph<T> {

    public void addNode(final T node);

    public void addEdge(final T from, final T to);

    public Iterable<T> adj(final T node);

}
