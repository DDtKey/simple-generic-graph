package com.ddtkey.graphs.impl;

import com.ddtkey.graphs.api.Graph;

import java.util.*;

public class UndirectedGraph<V> implements Graph<V> {
    protected final Map<Vertex<V>, Set<Vertex<V>>> adjacencyVertices = new HashMap<>();

    public UndirectedGraph() {
    }

    @Override
    public void addVertex(V value) {
        this.adjacencyVertices.putIfAbsent(new Vertex<>(value), new HashSet<>());
    }

    @Override
    public void addEdge(V firstValue, V secondValue) {
        var vertex1 = new Vertex<>(firstValue);
        var vertex2 = new Vertex<>(secondValue);

        Optional.ofNullable(adjacencyVertices.get(vertex1))
                .orElseThrow(() -> this.missingVertexException(vertex1))
                .add(vertex2);

        Optional.ofNullable(adjacencyVertices.get(vertex2))
                .orElseThrow(() -> this.missingVertexException(vertex2))
                .add(vertex1);
    }

    @Override
    // Search algorithm implementations can be moved into separate classes to comply with the principle of single responsibility,
    // which will also allow them to be changed as needed.
    public Set<V> getPath(V from, V to) {
        // todo
        return null;
    }

    protected IllegalArgumentException missingVertexException(Vertex<?> vertex) {
        var errMsg = String.format("Vertex %s is absent in the graph", vertex);
        return new IllegalArgumentException(errMsg);
    }

}
