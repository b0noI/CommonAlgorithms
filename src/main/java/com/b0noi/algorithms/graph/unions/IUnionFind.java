package com.b0noi.algorithms.graph.unions;


import java.util.Set;

public interface IUnionFind<T> {

    public void union(final T p, final T q);

    public boolean connect(final T p, final T q);

    public int find(final T p);

    public int count();

    public void add(final T p);

    public Set<T> elements();

}
