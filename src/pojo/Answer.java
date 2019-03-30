package pojo;

import java.io.Serializable;
import java.util.List;

public class Answer implements Serializable {
    private int id;
    private int actualDepartTime;
    private List<Integer> shortestPath;
    public static final int numberPara = 3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActualDepartTime() {
        return actualDepartTime;
    }

    public void setActualDepartTime(int actualDepartTime) {
        this.actualDepartTime = actualDepartTime;
    }

    public List<Integer> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Integer> shortestPath) {
        this.shortestPath = shortestPath;
    }
}
