package test;

import graph.Digraph;
import org.junit.jupiter.api.Test;
import pojo.Road;

import java.util.List;

import static utils.ReadData.readRoad;

/**
 * menyaqingssssss
 */
public class TestDigraph {

    @Test
    public void testADD() {
        Digraph test = new Digraph(16);
        List<Road>  road = readRoad("data/roads.txt");

        for (Road r : road) {
            test.addEdge(r.getBeginId()-1,r.getEndId()-1);
            if(r.isBidirectional()) {
                test.addEdge(r.getEndId()-1,r.getBeginId()-1);
            }
        }
//        test.addEdge(1,2);
//        test.addEdge(2,3);
//        test.addEdge(3,4);
        String result = test.toString();
        System.out.println(result);
        //menyaqing
    }
}
