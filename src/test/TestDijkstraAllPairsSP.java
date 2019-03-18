package test;

import graph.DijkstraAllPairsSP;
import graph.DirectedEdge;
import graph.EdgeWeightedDigraph;
import org.junit.jupiter.api.Test;
import pojo.Car;
import utils.GenerateGraph;
import utils.WtriteData;

import java.io.IOException;
import java.util.*;

import static utils.ReadData.readCar;


public class TestDijkstraAllPairsSP {

    @Test
    public void testPath(){

        // 创建输出文件
        EdgeWeightedDigraph G = GenerateGraph.generateEdgeWeightedDigraph("data/roads.txt","data/Cross.txt");
        DijkstraAllPairsSP sp = new DijkstraAllPairsSP(G);
        //读入车辆文件，需要遍历，将车辆id，出发时间和最佳路径输出到txt
        List<Car> cars = readCar("data/Car.txt");
        // 如果将输出变成一个字符串。
        StringBuilder sb = new StringBuilder();
        String resString = "";
        WtriteData wd = new WtriteData();

        for (Car c : cars) {
            // #(carId,StartTime,RoadId...)
            Iterable<DirectedEdge> it = sp.path(c.getBeginId()-1,c.getEndId()-1);
            Iterator<DirectedEdge> dit= it.iterator();
            List<String> list = new LinkedList<>();
            while (dit.hasNext()) {
                DirectedEdge next = dit.next();
                list.add(next.toString());
            }
            Collections.reverse(list);

            sb.append("(" + c.getId() +","+ c.getDepartTime() + ",");

            for ( int i = 0; i < list.size(); ++i) {
                if ( i < list.size() - 1)
                    sb.append(list.get(i) + ",");
                else
                    sb.append(list.get(i));
            }

            sb.append(")\n");
            resString = sb.toString();
            //System.out.print(resString);

        }
        System.out.print(resString);
        try {
            wd.fileOutputStream(resString,"data/answer.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
