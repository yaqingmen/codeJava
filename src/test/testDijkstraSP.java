package test;

import graph.DijkstraSP;
import graph.DirectedEdge;
import graph.EdgeWeightedDigraph;
import org.junit.jupiter.api.Test;
import pojo.Road;
import utils.GenerateGraph;

import java.util.List;
import java.util.Stack;

import static utils.ReadData.readRoad;

public class testDijkstraSP {

    @Test
    public void testShortedPath() {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(16);
        List<Road> road = readRoad("data/roads.txt");

        //将输入文件转化成边
        for (Road r: road) {
            DirectedEdge e = new DirectedEdge(r.getId(),r.getBeginId()-1,r.getEndId()-1,1);
            G.addEdge(e);
        }
        System.out.println(G.toString());
        int s = 0;//从起点
        // compute shortest paths
        DijkstraSP sp = new DijkstraSP(G, s);
        // print shortest path
        for (int t = 0; t < G.V(); t++) {
            if (sp.hasPathTo(t)) {
                System.out.printf("%d to %d (%.2f)  ", s, t, sp.distTo(t));
                for (DirectedEdge e : sp.pathTo(t)) {
                    System.out.print(e + "   ");
                }
                System.out.println();
            }
            else {
                System.out.printf("%d to %d         no path\n", s, t);
            }
        }
    }

    @Test
    public void testPathto() {
        // 1.创建EightWeightedDigraph
        EdgeWeightedDigraph G = GenerateGraph.generateEdgeWeightedDigraph("data/roads.txt","data/Cross.txt");
        // 2.创建DijkstraSP
        DijkstraSP dsp = new DijkstraSP(G,0);
        //3.调用pathto
        Stack<DirectedEdge> s = new Stack<>();
        Iterable<DirectedEdge> directedEdges = dsp.pathTo(15);
        for (DirectedEdge e: directedEdges) {
            System.out.println(e);
        }

    }
}
