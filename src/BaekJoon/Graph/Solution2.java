package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution2 {
    static int v;
    static int e;
    static Edge[] edges;
    static int parents[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        edges = new Edge[e];
        parents = new int[v+1];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(s, f, w);
        }

        System.out.println();
    }

    static int kruskal(){
        int ans = 0, cnt = 0;

        Arrays.sort(edges);
        make();

        for(Edge e: edges){
            if(union(e.start, e.end)){
                ans += e.weight;
                //간선 수 = 정점 수 - 1
                if(++cnt == v-1 ) return ans;
            }
        }
        return ans;
    }

    static boolean union(int a, int b){
        int parent1 = find(a);
        int parent2 = find(b);

        if(parent1 == parent2) return false;
        parents[parent1] = parent2;
        return true;
    }

    static int find(int x){
        if(x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }

    //정점 초기화
    static void make(){
        for(int i = 1; i <= v; i++){
            parents[i] = i;
        }
    }

    static class Edge implements Comparable<Solution.Edge> {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Solution.Edge o) {
            return weight - o.w;
        }
    }
}
