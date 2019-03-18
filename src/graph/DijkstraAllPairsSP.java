package graph;

public class DijkstraAllPairsSP {
    private DijkstraSP[] all ;
    public DijkstraAllPairsSP(EdgeWeightedDigraph G)
    {
        // 创建一个大小为顶点数的DijkstraSP数组
        all = new DijkstraSP[G.V()];
        for (int v = 0; v < G.V(); v++) {
            //一张图G由很多个起始点
            all[v] = new DijkstraSP(G,v);
        }

    }
    public Iterable<DirectedEdge> path (int s, int t) {
        return all[s].pathTo(t);
    }
    public double dist(int s,int t) {
        return all[s].distTo(t);
    }
}
