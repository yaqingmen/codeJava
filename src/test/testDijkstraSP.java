package test;

import graph.DijkstraSP;
import graph.DirectedEdge;
import graph.EdgeWeightedDigraph;
import org.junit.jupiter.api.Test;
import pojo.Road;

import java.util.List;

import static utils.ReadData.readRoad;

public class testDijkstraSP {

    @Test
    public void testShortedPath() {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(16);
        List<Road> road = readRoad("data/roads.txt");

        //将输入文件转化成边
        for (Road r: road) {
            DirectedEdge e = new DirectedEdge(r.getBeginId()-1,r.getEndId()-1,1);
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
}
