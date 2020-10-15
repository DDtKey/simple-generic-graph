package com.ddtkey.graphs;

import com.ddtkey.graphs.api.Graph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTests {

    @Test
    public void testUndirectedPath() {
        Graph<String> graph = Graph.undirectedGraph();
        graph.addVertex("A");
        graph.addVertex("B");

        graph.addEdge("B", "A");

        var pathAtoB = graph.getPath("A", "B");
        var pathBtoA = graph.getPath("B", "A");

        assertArrayEquals(new String[]{"A", "B"}, pathAtoB.toArray());
        assertArrayEquals(new String[]{"B", "A"}, pathBtoA.toArray());
    }

    @Test
    public void testDirectedPath() {
        Graph<String> graph = Graph.directedGraph();
        graph.addVertex("A");
        graph.addVertex("B");

        graph.addEdge("B", "A");

        var pathAtoB = graph.getPath("A", "B");
        var pathBtoA = graph.getPath("B", "A");

        // We created only B -> A edge
        assertArrayEquals(new String[]{}, pathAtoB.toArray());
        assertArrayEquals(new String[]{"B", "A"}, pathBtoA.toArray());

        // Test bidirectional edge in directed graph
        graph.addEdge("A", "B");
        pathAtoB = graph.getPath("A", "B");
        assertArrayEquals(new String[]{"A", "B"}, pathAtoB.toArray());
    }

    @Test
    public void testAddIncorrectEdge() {
        Graph<Integer> graph = Graph.undirectedGraph();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        assertDoesNotThrow(() -> graph.addEdge(1, 2));
        assertDoesNotThrow(() -> graph.addEdge(1, 3));
        assertDoesNotThrow(() -> graph.addEdge(2, 3));

        assertThrows(IllegalArgumentException.class, () -> graph.addEdge(2, 4), "Vertex 4 is absent in the graph");
        assertThrows(IllegalArgumentException.class, () -> graph.addEdge(5, 2), "Vertex 5 is absent in the graph");
    }

    @Test
    public void testPathBetweenSameVertices() {
        Graph<Integer> graph = Graph.undirectedGraph();
        graph.addVertex(1);
        graph.addVertex(2);

        graph.addEdge(1, 2);

        assertArrayEquals(new Integer[]{1}, graph.getPath(1, 1).toArray());
    }

    @Test
    public void testGetNonexistentPath() {
        Graph<Integer> graph = Graph.undirectedGraph();
        graph.addVertex(1);
        graph.addVertex(2);

        assertArrayEquals(new Integer[]{}, graph.getPath(1, 2).toArray());
    }
}
