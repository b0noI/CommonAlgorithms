package com.b0noi.algorithms.graph.search;


import com.b0noi.algorithms.graph.model.IGraph;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;

abstract class AbstractSearcher<T> implements ISourceNodePathSeracher<T> {

    protected final Map<T, T> edgeTo = new HashMap<>();

    public static <T> AbstractSearcher<T> prepareSearcher(final AbstractSearcher<T> instance, final IGraph<T> graph, final T source) {
        instance.edgeTo.put(source, null);
        instance.prepareSearcher(graph, source);
        return instance;
    }

    @Override
    public boolean hasPathTo(final T node) {
        return edgeTo.containsKey(node);
    }

    @Override
    public Optional<Iterable<T>> pathTo(final T node) {
        if (!hasPathTo(node)) return Optional.empty();
        final Stack<T> path = new Stack<>();
        T cuurentNode = node;
        while (cuurentNode != null) {
            path.add(cuurentNode);
            cuurentNode = edgeTo.get(cuurentNode);
        }
        return Optional.of(path);
    }

    protected abstract void prepareSearcher(final IGraph<T> graph, final T node);

}
