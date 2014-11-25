package com.b0noi.algorithms.graph.search;

import com.b0noi.algorithms.graph.model.IGraph;
import com.b0noi.algorithms.graph.model.MapBasedGraph;
import com.b0noi.algorithms.sort.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.IntSummaryStatistics;

import static org.testng.Assert.*;

public class SearcherTest {

    @Test
    public void testDepthFirstPathSearcher() throws Exception {
        // input arguments
        final IGraph<Integer> graph = new MapBasedGraph<>();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);

        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);

        graph.addEdge(3, 1);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);

        graph.addEdge(4, 1);
        graph.addEdge(4, 2);
        graph.addEdge(4, 3);

        final Integer sourceNode = 1;

        // mocks

        // expected results

        // creating test instance
        final ISourceNodePathSeracher<Integer> seracher = DepthFirstPathSearcher.createSeracher(graph, sourceNode);

        testAbstractSearhcer(seracher);
    }

    @Test
    public void testBreadthFirstSearcher() throws Exception {
        // input arguments
        final IGraph<Integer> graph = new MapBasedGraph<>();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);

        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);

        graph.addEdge(3, 1);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);

        graph.addEdge(4, 1);
        graph.addEdge(4, 2);
        graph.addEdge(4, 3);

        final Integer sourceNode = 1;

        // mocks

        // expected results

        // creating test instance
        final ISourceNodePathSeracher<Integer> seracher = BreadthFirstSearcher.createSeracher(graph, sourceNode);

        testAbstractSearhcer(seracher);
    }

    private void testAbstractSearhcer(final ISourceNodePathSeracher<Integer> seracher) {
        // result assert
        assertTrue(seracher.hasPathTo(1));
        assertTrue(seracher.hasPathTo(2));
        assertTrue(seracher.hasPathTo(3));
        assertTrue(seracher.hasPathTo(4));

        assertFalse(seracher.hasPathTo(5));

        assertNotNull(seracher.pathTo(2).get());
        assertNotNull(seracher.pathTo(3).get());
        assertNotNull(seracher.pathTo(4).get());
        assertNotNull(seracher.pathTo(1).get());

        assertFalse(seracher.pathTo(5).isPresent());
    }

}