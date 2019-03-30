package test;

import org.junit.jupiter.api.Test;
import pojo.Car;
import pojo.Cross;
import pojo.Road;
import utils.FileUtil;
import utils.ReadData;


import java.util.*;

public class TestUtils {
    List<Road> list;

    @Test
    public void testReadRoad() {
        List<Road> listroad;
        listroad = ReadData.readRoad("data/road.txt");
        System.out.println(listroad);
    }

    @Test
    public void testReadCar() {
        List<Car> listCar;
        listCar = ReadData.readCar("data/car.txt");
        System.out.println(listCar);
    }

    @Test
    public void testReadCross() {
        List<Cross> listCross;
        listCross = ReadData.readCross("data/cross.txt");
        System.out.println(listCross);
    }
//    @Test
//    public void testMap2Txt(){
//        Map map = new HashMap();
//        List<Integer> t1 = new ArrayList<>();
//        t1.add(1);
//        t1.add(2);
//        t1.add(3);
//
//        map.put(1,t1);
//        map.put(3,t1);
//        map.put(4,t1);
//        FileUtil.map2Txt(map,"data/2.txt");
//
//    }
//    @Test
//    public void testString2txt(){
//        String str = "123";
//        FileUtil.string2Txt(str,"data/1.txt");
//    }




}
