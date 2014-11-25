package com.b0noi.algorithms.graph.search;


import com.b0noi.algorithms.graph.model.IGraph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class BreadthFirstSearcher<T> extends AbstractSearcher<T> {

    private BreadthFirstSearcher() {}

    public static <T> AbstractSearcher<T> createSeracher(final IGraph<T> graph, final T source) {
        final BreadthFirstSearcher<T> searcher = new BreadthFirstSearcher<>();
        return AbstractSearcher.prepareSearcher(searcher, graph, source);
    }

    @Override
    protected void prepareSearcher(final IGraph<T> graph, final T node) {
        final Queue<T> queue = new ArrayDeque<>();
        queue.add(node);
        for (T element : queue) {
            for (T nextNode : graph.adj(element)) {
                if (!edgeTo.containsKey(nextNode)) {
                    edgeTo.put(nextNode, element);
                    queue.add(nextNode);
                }
            }
        }
    }

}
