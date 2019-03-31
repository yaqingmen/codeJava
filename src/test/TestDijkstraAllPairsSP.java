package test;

import graph.DijkstraAllPairsSP;
import graph.DirectedEdge;
import graph.EdgeWeightedDigraph;

import org.junit.jupiter.api.Test;

import pojo.Answer;
import pojo.Car;
import pojo.Cross;
import pojo.Road;
import utils.FileUtil;


import java.util.*;

import static utils.FileUtil.ListAnswer2txt;
import static utils.FileUtil.deepCopy;
import static utils.ReadData.*;


public class TestDijkstraAllPairsSP {

//    @Test
//    public void testPath() {
//        // 创建加权有向图G
//        EdgeWeightedDigraph G = GenerateGraph.generateEdgeWeightedDigraph("data/train2/road.txt", "data/train2/cross.txt");
//        // 根据G初始化DSP对象
//        DijkstraAllPairsSP sp = new DijkstraAllPairsSP(G);
//        //读入车辆文件，需要遍历，将车辆id，出发时间和最佳路径输出到txt
//        List<Car> cars = readCar("data/train2/car.txt");
//        // 将输出变成一个字符串。
//        StringBuilder sb = new StringBuilder();
//        String resString = "";
//        WtriteData wd = new WtriteData();
//        // 一些参数
//        //int M = cars.size() > 1000 ? cars.size() / 1000 : 1;
//        List<Map.Entry<Integer,List<Integer>>> roads = null;
//
//        //统计道路出现的次数
//        Map<Integer,List<Integer>> roadMap = new HashMap<>();
//        //遍历读取每一辆车
//        for (int i = 0; i < cars.size(); ++i) {
//            Car c = cars.get(i);
//            // #(carId,StartTime,RoadId...)
//            Iterable<DirectedEdge> it = sp.path(c.getBeginId() - 1, c.getEndId() - 1);
//            //对于里面装的每一条边，统计roads出现的次数
//
//        for (DirectedEdge e : it ) {
//            // 计算时间
//            //totalweigth += e.weight();
//            int roadID = Integer.parseInt(e.toString());
//            if (!roadMap.containsKey(roadID)) {
//                //将经过当前道路的car的ID加入list里。
//                roadMap.put(roadID, new ArrayList<>(c.getId()));
//            } else {
//                List<Integer> roadids = roadMap.get(roadID);
//                roadids.add(c.getId());
//                roadMap.put(roadID, roadids);
//            }
//        }
//
//        //按照值排序输出
//        roads = new ArrayList<Map.Entry<Integer,List<Integer>>>(roadMap.entrySet());
//        //然后通过比较器来实现排序
//        Collections.sort(roads,new Comparator<Map.Entry<Integer,List<Integer>>>() {
//            //升序排序
//            @Override
//            public int compare(Map.Entry<Integer, List<Integer>> o1,
//                               Map.Entry<Integer, List<Integer>> o2) {
//                int flag = 0;
//                if (o1.getValue().size() > o2.getValue().size())
//                    flag = -1;
//                if (o1.getValue().size() < o2.getValue().size())
//                    flag = 1;
//                return flag;
//            }
//        });
//
//    }
//
//    //遍历map中 车经过的道路和道路的次数
//    Set<Integer> set1 = new HashSet<>();
//    Set<Integer> set2 = new HashSet<>();
//    Set<Integer> set3 = new HashSet<>();
//    Set<Integer> set4 = new HashSet<>();
//    //经过两层for循环，从map生成4个set.
//        for (Map.Entry<Integer, List<Integer>> mapping : roads) {
//        //System.out.println(mapping.getKey() + ":" + mapping.getValue().size());
//        List<Integer> carslist = mapping.getValue();
//        if (carslist.size() > 1000) {
//            int n = carslist.size();
//            for (int j = 0; j < n; ++j) {
//                if (j < (int)(0.25 * n)){
//                    set1.add(carslist.get(j));
//                }else if (j < (int)(0.5 * n)){
//                    set2.add(carslist.get(j));
//                }else if (j < (int)(0.75 * n)){
//                    set3.add(carslist.get(j));
//                }else{
//                    set4.add(carslist.get(j));
//                }
//            }
//        }
//    }
//    //查看set 1~4
////        System.out.println(set1.size());
////        System.out.println(set2.size());
////        System.out.println(set3.size());
////        System.out.println(set4.size());
////        for(Integer id : set1){
////            System.out.println(id);
////        }
//
//        for (int i = 0; i < cars.size(); ++i) {
//        Car c = cars.get(i);
//        // #(carId,StartTime,RoadId...)
//        Iterable<DirectedEdge> it = sp.path(c.getBeginId() - 1, c.getEndId() - 1);
//
//        //将输出的有向边的集合添加到list里，翻转list得到正确顺序
//        Iterator<DirectedEdge> dit = it.iterator();
//        List<String> list = new LinkedList<>();
//        while (dit.hasNext()) {
//            DirectedEdge next = dit.next();
//            list.add(next.toString());
//        }
//        Collections.reverse(list);
//
//        //c.setDepartTime(c.getDepartTime() + (i / M) * M / 2);
//        if(set1.contains(c.getId()))
//            c.setDepartTime(c.getDepartTime() + 100 );  //形成出发时间，
//        else if(set2.contains(c.getId()))
//            c.setDepartTime(c.getDepartTime() + 200);//在第二子集，
//        else if(set3.contains(c.getId()))
//            c.setDepartTime(c.getDepartTime() + 300);
//        else if(set4.contains(c.getId()))
//            c.setDepartTime(c.getDepartTime() + 400);
//        else
//            c.setDepartTime(c.getDepartTime() + 2000);
//
//        sb.append("(" + c.getId() + "," + c.getDepartTime() + ",");
//
//            for (int ii = 0; ii < list.size(); ++ii) {
//                if (ii < list.size() - 1)
//                    sb.append(list.get(ii) + ",");
//                else
//                    sb.append(list.get(ii));
//            }
//
//            sb.append(")\n");
//            resString = sb.toString();
//    }
//
//    //将map存到txt中
//    //mapEntry2txt(roads,"data/roadsCount.txt");
//
//    //将结果大字符串写入answer.txt
////    string2Txt(resString,"data/train2/answer.txt");
////
//    }

    @Test
    public void testPatition() {
        // 1.生成answer.txt
        // 1.1创建加权有向图G
        //EdgeWeightedDigraph G = GenerateGraph.generateEdgeWeightedDigraph("data/train1/road.txt", "data/train1/cross.txt");

        //知道路口的总个数
        List<Cross> cross = readCross("data/train1/cross.txt");
        //for(Cross cross : list)
        //最后一个cross的id + 1，应该创建这么大的数组
        Map<Integer,Integer> cross2index = new LinkedHashMap<>();
        for(int i =0; i<cross.size();i++) {
            if(!cross2index.containsKey(cross.get(i).getId()))
                cross2index.put(cross.get(i).getId(),i);
        }
        //用路口做顶点初始化EdgeWeightedDigraph
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(cross.size());
        List<Road> road = readRoad("data/train1/road.txt");

        //将输入文件转化成边
        for (Road r: road) {
            //无论是否双向，1 ->2 都是肯定要添加的边
            double weight = (r.getLength() * 1.0)/r.getSpeedLimit(); //把道路的最短时间当作权重
            DirectedEdge e1 = new DirectedEdge(r.getId(),cross2index.get(r.getBeginId()),cross2index.get(r.getEndId()),weight);
            G.addEdge(e1);
            //如果是双向的，那就再添加 2-->1
            if (r.isBidirectional()) {
                DirectedEdge e2 = new DirectedEdge(r.getId(),cross2index.get(r.getEndId()),cross2index.get(r.getBeginId()),weight);
                G.addEdge(e2);
            }
        }
        //System.out.println(G);
        // 1.2根据G初始化DSP对象
        DijkstraAllPairsSP sp = new DijkstraAllPairsSP(G);
        //1.3 读入车辆文件，需要遍历，将车辆id，出发时间和最佳路径输出到txt
        List<Car> cars = readCar("data/train1/car.txt");

        //2.生成answer
        List<Answer> answers = FileUtil.GenerateAnswerlist(sp, cars,cross2index);
        System.out.println("统计前的answers个数: "+answers.size());
        //创建answers的备份
        List<Answer> at = deepCopy(answers);
        List<List<Answer>> associatedList = new ArrayList<List<Answer>>();

        //生成相关集合
        while (at.size() > 1) {
            List<Answer> associated = new ArrayList<>();
            // notassociated1 = new ArrayList<>();
            Answer a0 = at.get(0);
            at.remove(a0);
            associated.add(a0);
            for (int i = 0; i < at.size(); i++) {
                //如果和第一个数相关连就把id放到associated1里
                Answer a = at.get(i);
                if (isAssociated(a.getShortestPath(), a0.getShortestPath())) {
                    //如果和第一个向量相连，那就加入
                    associated.add(a);
                    at.remove(a);
                }
            }
            associatedList.add(associated);
        }
        System.out.println("一共有" + associatedList.size() + "个相关联的集合。");
        Integer sum =0;
        for(int i=0; i< associatedList.size();i++) {
            sum += associatedList.get(i).size();
        }
        System.out.println("统计后的answers个数："+ sum);
        // 根据生成的关联集合修改answers的出发时间
        //将多个list,写成一个大list，写入answer.txt
        //List<Answer> res = new ArrayList<>();
                if(!at.isEmpty()) {
//                    for (Answer a : at) {
//                        //res.add(a);
//
//                    }
                    ListAnswer2txt(at,"data/train1/answer.txt");
                }
                int cnt = 0;
                for (List<Answer> list : associatedList) {
                    cnt++;
                    int M = 500;
                    int detime = 100;
                    //int M = list.size() > 100 ? list.size() / 100 : 1;
                    //int hundredParam = (list.size() > 100 && list.size() < 1000 ) ? list.size()/10 : 1;
                    System.out.println("这是第" + cnt + "个集合，" + "它有" + list.size() + "个元素。");
                    //对关联的车辆数大于1000的分批
                    if (list.size() >= M) {
                        int i = 0;
                        M = 500;
                        detime = 100;
                        while (i<list.size()) {
                            Answer a = list.get(i);
                            a.setActualDepartTime(a.getActualDepartTime() + detime);
                            if ((i % M) == 0) {
                                M += M;
                                detime += detime;
                            }

                            i++;
                        }
                        ListAnswer2txt(list,"data/train1/answer.txt");
//                    int M = list.size() > 10 ? list.size() / 10 : 1;
//                    //int hundredParam = (list.size() > 100 && list.size() < 1000 ) ? list.size()/10 : 1;
//                    System.out.println("这是第" + cnt + "个集合，" + "它有" + list.size() + "个元素。");
//                    //对关联的车辆数大于1000的分批
//                    if (list.size() >= 100) {
//                        for (int i = 0; i < list.size(); i++) {
//                            Answer a = list.get(i);
//                            a.setActualDepartTime(a.getActualDepartTime() + (i / M) * M); //(i / M) * M / 2
////                            res.add(a);
//                        }
//                        ListAnswer2txt(list,"data/train1/answer.txt");
            }else{
//                for(Answer a: list){
//                    res.add(a);
//                }
                 ListAnswer2txt(list,"data/train1/answer.txt");
            }

        }

    }

    public boolean isAssociated(List<Integer> shortestPath1, List<Integer> shortestPath2) {
        //首先对两个arraylist进行排序,只排序原数组的深拷贝，不改变原数组
        List<Integer> t1 = FileUtil.deepCopy(shortestPath1);
        List<Integer> t2 = FileUtil.deepCopy(shortestPath2);
        Collections.sort(t1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? 1 : -1;
            }
        });
        Collections.sort(t2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? 1 : -1;
            }
        });
        int p1 = 0 , p2 = 0;
        int len1 = t1.size();
        int len2 = t2.size();
        while(p1 < len1 && p2 <len2) {
            if(t1.get(p1) < t2.get(p2) && p1 < len1) {
                p1++;
            }else if(t1.get(p1) > t2.get(p2) && p2 < len2){
                p2++;
            }else {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testAssociated(){
        List<Integer> t1 = new ArrayList<>();
        List<Integer> t2 = new ArrayList<>();
        //t1
        t1.add(5036);
        t1.add(5049);
        t1.add(5063);
        t1.add(5078);

        //t2
        t2.add(5007);
        t2.add(5022);
        t2.add(5030);
        t2.add(5036);
        t2.add(5049);
        t2.add(5063);
        System.out.println(isAssociated(t1,t2));

    }
    @Test
    public void test01() {
        List<Integer> src = new ArrayList<>();

        for(int i =0; i<10;i++){
            src.add(i);
        }


        List<Integer> dest = FileUtil.deepCopy(src);
//        for(Integer i: dest){
//            System.out.println(i);
//        }
        System.out.println(dest);
        dest.set(3,100);
        System.out.println(dest);
        System.out.println(src);

    }


}




