package test;

import org.junit.jupiter.api.Test;
import pojo.Answer;
import utils.ReadData;

import java.util.ArrayList;
import java.util.List;

public class TestReadData {

    @Test
    public void testReadAnswer() {

        List<Answer> answers = ReadData.readAnswer("data/answer.txt");
        for (Answer a : answers) {
            System.out.println(a.getId());
            System.out.println(a.getActualDepartTime());
            //System.out.println(a.getShortestPath().size());
            List<Integer> list = a.getShortestPath();
            for(Integer i: list) {
                //输出最短子序列的每一条道路
                System.out.println(i);
            }
        }

    }
}
