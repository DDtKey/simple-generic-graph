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
    public List<V> getPath(V from, V to) {
        var visited = new HashSet<V>();
        var path = new LinkedList<V>();

        if (Objects.equals(from, to)) { // Checking if the path goes from the vertex to itself
            path.add(from);
            return path;
        }

        if (deepFirstSearch(path, visited, new Vertex<>(from), to)) {
            path.addFirst(from); // include first element if path found
        }

        return path;
    }

    /**
     * The DFS algorithm was chosen to make it easier to find the path between vertices.
     */
    boolean deepFirstSearch(LinkedList<V> path, Set<V> visited, Vertex<V> fromVertex, V target) {
        for (var vertex : this.adjacencyVertices.get(fromVertex)) {
            var data = vertex.getData();
            if (!visited.contains(data)) {
                visited.add(data);

                if (data.equals(target)
                        || deepFirstSearch(path, visited, vertex, target)){
                    path.addFirst(data);
                    return true;
                }
            }
        }
        return false;
    }



    protected IllegalArgumentException missingVertexException(Vertex<?> vertex) {
        var errMsg = String.format("Vertex %s is absent in the graph", vertex);
        return new IllegalArgumentException(errMsg);
    }

}
