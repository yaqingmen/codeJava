package utils;

import graph.DijkstraAllPairsSP;
import graph.DirectedEdge;
import pojo.Answer;
import pojo.Car;

import java.io.*;
import java.util.*;

public class FileUtil {
    static public FileReader getFileReader(String path) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fileReader;
    }
    static  public void closeFileReader(FileReader fileReader) {
        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static public BufferedReader getBufferedReader(FileReader fileReader) {
        BufferedReader bufferedReader = null;
        bufferedReader = new BufferedReader(fileReader);
        return bufferedReader;
    }
    static  public void closeBufferedReader(BufferedReader bufferedReader) {
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //将HashMap的数据输出到txt中
    static public void map2Txt(Map map,String savepath) {
        try {
            String line = System.getProperty("line.separator");
            StringBuffer str = new StringBuffer();
            FileWriter fw = new FileWriter(savepath, false);
            Set set = map.entrySet();
            Iterator iter = set.iterator();
            while(iter.hasNext()){
                Map.Entry entry = (Map.Entry)iter.next();
                str.append(entry.getKey()+" : "+entry.getValue()).append(line);
            }
            fw.write(str.toString());
            fw.close();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    static public void mapEntry2txt(List<Map.Entry<Integer,List<Integer>>> roads, String savepath){
        try {
            String line = System.getProperty("line.separator");
            StringBuffer strMap = new StringBuffer();
            FileWriter fw = new FileWriter(savepath, true);
            for (Map.Entry<Integer, List<Integer>> mapping : roads) {
                strMap.append(mapping.getKey() + ":" + mapping.getValue()).append(line);
            }
            fw.write(strMap.toString());
            fw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

//    static public void string2Txt(String resString, String savepath) {
//        WtriteData wd = new WtriteData();
//        try {
//            wd.fileOutputStream(resString, savepath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    public static void ListAnswer2txt(List<Answer> list,String savepath) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i< list.size(); i++){
            Answer a = list.get(i);
            stringBuffer.append("("+a.getId()+","+a.getActualDepartTime()+",");
            List<Integer> alist = a.getShortestPath();
            for(int j = 0; j < alist.size(); j++) {
                //如果不是最后一个元素，就加，
                if (j != (alist.size()-1))
                    stringBuffer.append(alist.get(j)+",");
                else
                    stringBuffer.append(alist.get(j)+")\n");
            }
        }
        String str = stringBuffer.toString();
        WtriteData wd = new WtriteData();
        try {
            wd.fileOutputStream(str, savepath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<Answer> GenerateAnswerlist(DijkstraAllPairsSP sp, List<Car> cars,Map<Integer,Integer> cross2index) {
        List<Answer> answers = new ArrayList<>();
        for (int i = 0; i < cars.size(); ++i) {
            Car car = cars.get(i);
            Answer a = new Answer();
            a.setId(car.getId());
            a.setActualDepartTime(car.getDepartTime());
            int s = cross2index.get(car.getBeginId());
            int v = cross2index.get(car.getEndId());
            Iterable<DirectedEdge> it = sp.path(s,v);
            Iterator<DirectedEdge> dit = it.iterator();
            List<Integer> tmp = new ArrayList<>();
            while (dit.hasNext()) {
                DirectedEdge next = dit.next();
                tmp.add(Integer.valueOf(next.toString()));
            }
            Collections.reverse(tmp);
            a.setShortestPath(tmp);
            answers.add(a);
        }
        return answers;
    }
    //deep copy
    public static <T> List<T> deepCopy(List<T> src){
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(byteOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.writeObject(src);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(byteIn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        @SuppressWarnings("unchecked")
        List<T> dest = null;
        try {
            dest = (List<T>) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dest;

    }

}
