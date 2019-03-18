package test;

import graph.EdgeWeightedDigraph;
import org.junit.jupiter.api.Test;
import utils.GenerateGraph;

public class TestGenerateGraph {
    @Test
    public void testGenerateDigraph() {

        EdgeWeightedDigraph G1 = GenerateGraph.generateEdgeWeightedDigraph("data/roads.txt","data/Cross.txt");
    }
}
