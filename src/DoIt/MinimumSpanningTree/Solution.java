package DoIt.MinimumSpanningTree;

import java.util.PriorityQueue;
import java.util.Scanner;

/*
    064 최소 신장 트리 구하기 정석 문제
 */

public class Solution {
    static int[] parent;
    static PriorityQueue<Edge> queue;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        queue = new PriorityQueue<>();
        parent = new int[n+1];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        for(int i = 0; i < m; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            int v = sc.nextInt();
            queue.add(new Edge(s, e, v));
        }
        int useEdge = 0;
        int result = 0;
        while(useEdge < n-1){
            Edge now = queue.poll();
            if(find(now.s) != find(now.e)){ //같은 부모가 아니라면 연결해도 사이클이 생기지 않음
                union(now.s, now.e);
                result = result + now.v;
                useEdge++;
            }
        }
        System.out.println(result);
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;
        }
    }

    public static int find(int a){
        if(a == parent[a])
            return a;
        else return  parent[a] = find(parent[a]); // 재귀 함수 형태로 경로 압축
    }

    static class Edge implements Comparable<Edge> {
        int s;
        int e;
        int v;

        public Edge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(Edge o) {
            //가중치 기준으로 오름차순 정렬
            return this.v - o.v;
        }
    }
}
