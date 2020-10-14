package com.ddtkey.graphs.impl;

public class DirectedGraph<V> extends UndirectedGraph<V> {

    @Override
    public void addEdge(V fromValue, V toValue) {
        var vertex1 = new Vertex<>(fromValue);
        var vertex2 = new Vertex<>(toValue);
        this.vertices.get(vertex1).add(vertex2);
    }
}
