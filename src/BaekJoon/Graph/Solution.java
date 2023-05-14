package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    static ArrayList<Edge>[] arr;
    //static boolean visited[];
    static int v;
    static int e;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        arr = new ArrayList[v+1];
        //visited = new boolean[v+1];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[s].add(new Edge(f, w));
            arr[f].add(new Edge(s, w));
        }

        System.out.println(prim());
    }
    static long prim(){
        boolean[] visited = new boolean[v+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));

        long ans = 0;
        int cnt = 0;
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            if(visited[edge.v]) continue;

            ans = edge.w;
            visited[edge.v] = true;
            if(++cnt == v) return ans;

            for(int i = 0; i < arr[edge.v].size(); i++){
                Edge next = arr[edge.v].get(i);
                if(visited[next.v]) continue;
                pq.add(next);
            }
        }
        return ans;
    }

    static class Edge implements Comparable<Edge> {
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
