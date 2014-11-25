package com.b0noi.algorithms.graph.search;


import java.util.Iterator;
import java.util.Optional;

public interface ISourceNodePathSeracher<T> {

    public boolean hasPathTo(final T node);

    public Optional<Iterable<T>> pathTo(final T node);

}
