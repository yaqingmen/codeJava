package test;

import graph.DijkstraAllPairsSP;
import graph.EdgeWeightedDigraph;
import org.junit.jupiter.api.Test;
import pojo.Car;
import utils.FileUtil;
import utils.GenerateGraph;

import java.util.List;

import static utils.ReadData.readCar;

public class TestGenerateGraph {
//    @Test
//    public void testGenerateDigraph() {
//
//        EdgeWeightedDigraph G1 = GenerateGraph.generateEdgeWeightedDigraph("data/road.txt","data/cross.txt");
//    }

//    @Test
//    public void testGenerateAnswerTxt() {
//        // 1.生成answer.txt
//        // 1.1创建加权有向图G
//        EdgeWeightedDigraph G = GenerateGraph.generateEdgeWeightedDigraph("data/road.txt", "data/cross.txt");
//        // 1.2根据G初始化DSP对象
//        DijkstraAllPairsSP sp = new DijkstraAllPairsSP(G);
//        //1.3 读入车辆文件，需要遍历，将车辆id，出发时间和最佳路径输出到txt
//        List<Car> cars = readCar("data/car.txt");
//        //1.4生成answer.txt
//        FileUtil.GenerateAnswerTxt(sp,cars,"data/answer.txt");
//    }
}
