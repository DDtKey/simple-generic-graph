package com.ddtkey.graphs;

import com.ddtkey.graphs.api.Graph;
import com.ddtkey.graphs.common.City;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class GraphTypesTests {

    @Test
    public void testStringGraph() {
        Graph<String> stringGraph = Graph.undirectedGraph();
        stringGraph.addVertex("A");
        stringGraph.addVertex("B");
        stringGraph.addVertex("C");

        stringGraph.addEdge("A", "B");
        stringGraph.addEdge("C", "B");

        var path = stringGraph.getPath("A", "C");
        assertArrayEquals(new String[]{"A", "B", "C"}, path.toArray());
    }

    @Test
    public void testIntegerGraph() {
        Graph<Integer> stringGraph = Graph.undirectedGraph();
        stringGraph.addVertex(1);
        stringGraph.addVertex(2);
        stringGraph.addVertex(3);

        stringGraph.addEdge(1, 2);
        stringGraph.addEdge(2, 3);

        var path = stringGraph.getPath(1, 3);
        assertArrayEquals(new Integer[]{1, 2, 3}, path.toArray());
    }

    @Test
    public void testCustomTypeGraph() {
        Graph<City> stringGraph = Graph.undirectedGraph();
        var moscow = City.of("Moscow", "Russia");
        var newYork = City.of("New York", "USA");
        var amsterdam = City.of("Amsterdam", "Netherlands");

        stringGraph.addVertex(moscow);
        stringGraph.addVertex(amsterdam);
        stringGraph.addVertex(newYork);

        stringGraph.addEdge(moscow, amsterdam);
        stringGraph.addEdge(amsterdam, newYork);

        var path = stringGraph.getPath(moscow, newYork);
        assertArrayEquals(new City[]{moscow, amsterdam, newYork}, path.toArray());
    }


}
