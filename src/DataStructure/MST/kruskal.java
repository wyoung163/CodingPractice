package DataStructure.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 최소신장트리: 그래프의 모든 정점을 잇지만 사이클이 없고 간선의 가중치의 합이 최소가 되는 트리
 */
public class kruskal {
    static StringTokenizer st;
    static int v; // 정점 수
    static int e; // 간선 수
    static int[] parent;
    static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();
        parent = new int[v+1];

        //부모 노드 세팅
        for(int i = 1; i <= v; i++){
            parent[i] = i;
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            pq.offer(new Edge(v1, v2, weight));
        }

        int weight = 0;
        while(!pq.isEmpty()){
            Edge now = pq.poll(); // 가중치가 가장 작은 간선
            if(find(now.v1) != find(now.v2)){
                union(now.v1, now.v2);
                weight += now.weight;
            }
        }

        System.out.println(weight);
    }

    // n1과 n2가 속한 집합 합치기
    public static void union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);

        parent[p2] = p1;
    }

    // n이 속한 집합의 루트 노드 값 반환 - 어떤 집합에 속하는지 찾는 연산
    public static int find(int n){
        if(parent[n] == n){
            return n;
        }
        return parent[n] = find(parent[n]);
    }
}

class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int weight;

    public Edge(int v1, int v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return weight - o.weight;
    }
}

/*
5 7
1 2 1
1 4 2
1 5 2
2 3 3
2 4 3
3 4 1
4 5 2
 */