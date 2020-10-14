package com.ddtkey.graphs;

import com.ddtkey.graphs.impl.UndirectedGraph;

import java.util.Set;

public interface Graph<V> {
    void addVertex(V value);
    void addEdge(V firstValue, V secondValue);
    Set<V> getPath(V from, V to);

    /**
     * @param <V> the Graph element type
     * @return empty undirected implementation of {@code Graph}
     */
    static <V> Graph<V> undirectedGraph() {
        return new UndirectedGraph<>();
    }

}
