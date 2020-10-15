package com.ddtkey.graphs.impl;

import java.util.Optional;

public class DirectedGraph<V> extends UndirectedGraph<V> {

    @Override
    public void addEdge(V fromValue, V toValue) {
        var vertex1 = new Vertex<>(fromValue);
        var vertex2 = new Vertex<>(toValue);

        Optional.ofNullable(adjacencyVertices.get(vertex1))
                .orElseThrow(() -> this.missingVertexException(vertex1))
                .add(vertex2);
    }
}
