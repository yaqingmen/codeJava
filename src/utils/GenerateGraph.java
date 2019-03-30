package utils;

import graph.DirectedEdge;
import graph.EdgeWeightedDigraph;

import pojo.Cross;
import pojo.Road;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static utils.ReadData.readCross;
import static utils.ReadData.readRoad;

public class GenerateGraph {

   // static public EdgeWeightedDigraph generateEdgeWeightedDigraph (String roadPpath,String crossPath) {
//       //知道路口的总个数
//        List<Cross> cross = readCross(crossPath);
//        //for(Cross cross : list)
//        //最后一个cross的id + 1，应该创建这么大的数组
//        Map<Integer,Integer> cross2index = new LinkedHashMap<>();
//        for(int i =0; i<cross.size();i++) {
//            if(!cross2index.containsKey(cross.get(i).getId()))
//                cross2index.put(cross.get(i).getId(),i);
//        }
//        //用路口做顶点初始化EdgeWeightedDigraph
//        EdgeWeightedDigraph G = new EdgeWeightedDigraph(cross.size());
//        List<Road> road = readRoad(roadPpath);
//
//        //将输入文件转化成边
//        for (Road r: road) {
//            //无论是否双向，1 ->2 都是肯定要添加的边
//            double weight = (r.getLength() * 1.0)/r.getSpeedLimit(); //把道路的最短时间当作权重
//            DirectedEdge e1 = new DirectedEdge(r.getId(),cross2index.get(r.getBeginId()),cross2index.get(r.getEndId()),weight);
//            G.addEdge(e1);
//            //如果是双向的，那就再添加 2-->1
//            if (r.isBidirectional()) {
//                DirectedEdge e2 = new DirectedEdge(r.getId(),cross2index.get(r.getBeginId()),cross2index.get(r.getEndId()),weight);
//                G.addEdge(e2);
//            }
//        }
        //System.out.println(G.toString());
        //return G;
   // }

}
