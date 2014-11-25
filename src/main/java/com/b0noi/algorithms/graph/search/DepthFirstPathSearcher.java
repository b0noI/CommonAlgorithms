package com.b0noi.algorithms.graph.search;


import com.b0noi.algorithms.graph.model.IGraph;

import java.util.*;

public class DepthFirstPathSearcher<T> extends AbstractSearcher<T> {

    private DepthFirstPathSearcher() {}

    public static <T> AbstractSearcher<T> createSeracher(final IGraph<T> graph, final T source) {
        final DepthFirstPathSearcher<T> searcher = new DepthFirstPathSearcher<>();
        return AbstractSearcher.prepareSearcher(searcher, graph, source);
    }

    protected void prepareSearcher(final IGraph<T> graph, final T node) {
        for (T nextNode : graph.adj(node)) {
            if (!edgeTo.containsKey(nextNode)) {
                edgeTo.put(nextNode, node);
                prepareSearcher(graph, nextNode);
            }
        }
    }

}
