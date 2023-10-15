package Algorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Concept {
    static ArrayList<Node>[] graph;

    public static void Dijkstra(int n, int start){
        boolean[] check = new boolean[n+1];
        int[] dist = new int[n+1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            int now = pq.poll().idx;
            if(check[now]) continue;
            check[now] = true;

            for(Node next: graph[now]){
                if(dist[next.idx] > dist[now] + next.cost){
                    dist[next.idx] = dist[now] + next.cost;
                    pq.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }
        for(int i : dist){
            if(i == INF) System.out.println(0 + " ");
            else System.out.println(i+" ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //정점의 개수, 간선의 개수
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++)  graph[i] = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0 ; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[v].add(new Node(w, cost));
        }

        int start = Integer.parseInt(bf.readLine());

        //다익스트라 알고리즘 수행
        Dijkstra(n, start);
    }
}

class Node implements Comparable<Node> {
    int idx;
    int cost;

    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o){
        return Integer.compare(this.cost, o.cost);
    }
}
