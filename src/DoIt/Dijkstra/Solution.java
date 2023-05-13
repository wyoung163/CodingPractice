package DoIt.Dijkstra;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution{
    int distances[];
    ArrayList<Edge>[] arr;

    void Dijkstra(){
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        pq.add(new Edge(1, 0));

        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            if(distances[edge.v] < edge.w){
                continue;
            }
            for(int i = 0; i < arr[edge.v].size(); i++){
                int v2 = arr[edge.v].get(i).v;
                int w2 = arr[edge.v].get(i).w + edge.w;
                if(distances[v2] > w2){
                    distances[v2] = w2;
                    pq.add(new Edge(v2, w2));
                }
            }
        }

    }

    class Edge implements Comparable<Edge>{
        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return w - o.w;
        }
    }
}
