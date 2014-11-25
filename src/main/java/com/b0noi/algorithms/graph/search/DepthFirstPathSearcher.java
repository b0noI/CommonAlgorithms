package com.b0noi.algorithms.graph.search;


import com.b0noi.algorithms.graph.model.IGraph;

import java.util.*;

public class DepthFirstPathSearcher<T> implements ISourceNodePathSeracher<T> {

    private final Map<T, T> edgeTo = new HashMap<>();

    private DepthFirstPathSearcher() {}

    public static <T> DepthFirstPathSearcher createSeracher(final IGraph<T> graph, final T source) {
        final DepthFirstPathSearcher searcher = new DepthFirstPathSearcher();
        searcher.edgeTo.put(source, null);
        searcher.dfs(graph, source);
        return searcher;
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

    private void dfs(final IGraph<T> graph, final T node) {
        for (T nextNode : graph.adj(node)) {
            if (!edgeTo.containsKey(nextNode)) {
                edgeTo.put(nextNode, node);
                dfs(graph, nextNode);
            }
        }
    }

}
