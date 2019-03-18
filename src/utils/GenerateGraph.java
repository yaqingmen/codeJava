package utils;

import graph.DirectedEdge;
import graph.EdgeWeightedDigraph;

import pojo.Cross;
import pojo.Road;

import java.util.List;

import static utils.ReadData.readCross;
import static utils.ReadData.readRoad;

public class GenerateGraph {

    static public EdgeWeightedDigraph generateEdgeWeightedDigraph (String roadPpath,String crossPath) {
       //知道路口的总个数
        List<Cross> list = readCross(crossPath);
        //用路口做顶点初始化EdgeWeightedDigraph
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(list.size());
        List<Road> road = readRoad(roadPpath);

        //将输入文件转化成边
        for (Road r: road) {
            //无论是否双向，1 ->2 都是肯定要添加的边
            double weight = (r.getLength() * 1.0)/r.getSpeedLimit(); //把道路的最短时间当作权重
            DirectedEdge e1 = new DirectedEdge(r.getId(),r.getBeginId()-1,r.getEndId()-1,weight);
            G.addEdge(e1);
            //如果是双向的，那就再添加 2-->1
            if (r.isBidirectional()) {
                DirectedEdge e2 = new DirectedEdge(r.getId(),r.getEndId()-1,r.getBeginId()-1,weight);
                G.addEdge(e2);
            }
        }
        //System.out.println(G.toString());
        return G;
    }

}
