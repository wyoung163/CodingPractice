package DataStructure.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
    정점 중심으로 최소 신장 트리 구함
    정점이 적을 때 크루스칼보다 유리

    1. 임의 정점 선택
    2. 그 정점과 인접한 정점을 잇는 간선 중 가중치가 가장 낮은 간선 선택
    3. 간선이 연결하는 정점 선택, 모든 정점에 대해 2번 과정 반복
 */
public class prim {
    static StringTokenizer st;
    static int v;
    static int e;
    static boolean[] visit;
    static PriorityQueue<Node> queue;
    static ArrayList<ArrayList<Node>> nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        visit = new boolean[v+1];
        queue = new PriorityQueue<>();

        nodes = new ArrayList<>();
        for(int i = 0; i <= v; i++){
            nodes.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodes.get(v1).add(new Node(v2, weight));
            nodes.get(v2).add(new Node(v1, weight));
        }

        queue.offer(new Node(1, 0));
        int sum = 0;
        while(!queue.isEmpty()){
            Node n = queue.poll();
            int to = n.to;
            int w = n.weight;

            if(visit[to]){
                continue;
            }
            visit[to] = true;
            sum+=w;

            for(Node next: nodes.get(to)){
                if(!visit[next.to]){
                    queue.offer(next);
                }
            }
        }
        System.out.println(sum);
    }
}

class Node implements Comparable<Node>{
    int to;
    int weight;

    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}
