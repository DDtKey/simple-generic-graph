package com.ddtkey.graphs.api;

import com.ddtkey.graphs.impl.DirectedGraph;
import com.ddtkey.graphs.impl.UndirectedGraph;

import java.util.Set;

/**
 * Simple Graph with the ability to specify the data type for vertices.
 * Supports both directed and undirected graph representations.
 *
 * {@code null} are not allowed as values of graph vertices!
 *
 * @param <V> - vertex data type
 */
public interface Graph<V> {

    void addVertex(V value);

    /**
     * In the case of a directed graph, an edge will be created between the vertices of the first and second values (firstValue -> secondValue).
     *
     * If there is no vertex in the current naive graph implementation, this may throw an IllegalArgumentException!
     *
     * @param firstValue - the value whose vertex should be associated with the vertex of the {@code secondValue}
     * @param secondValue - the value whose vertex should be associated with the vertex of the {@code firstValue}
     */
    void addEdge(V firstValue, V secondValue) throws IllegalArgumentException;

    Set<V> getPath(V from, V to);

    /**
     * @param <V> the Graph element type
     * @return empty undirected implementation of {@code Graph}
     */
    static <V> Graph<V> undirectedGraph() {
        return new UndirectedGraph<>();
    }

    /**
     * @param <V> the Graph element type
     * @return empty directed implementation of {@code Graph}
     */
    static <V> Graph<V> directedGraph() {
        return new DirectedGraph<>();
    }
}
