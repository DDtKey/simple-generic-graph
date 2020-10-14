package com.ddtkey.graphs.impl;

import com.ddtkey.graphs.Graph;

import java.util.*;

public class UndirectedGraph<V> implements Graph<V> {
    protected final Map<Vertex<V>, List<Vertex<V>>> vertices = new HashMap<>();

    public UndirectedGraph() {
    }

    @Override
    public void addVertex(V value) {
        this.vertices.putIfAbsent(new Vertex<>(value), new ArrayList<>());
    }

    @Override
    public void addEdge(V firstValue, V secondValue) {
        var vertex1 = new Vertex<>(firstValue);
        var vertex2 = new Vertex<>(secondValue);
        vertices.get(vertex1).add(vertex2);
        vertices.get(vertex2).add(vertex1);
    }

    // TODO
    @Override
    public Set<V> getPath(V from, V to) {
        return null;
    }
}
