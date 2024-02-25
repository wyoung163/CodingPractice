package DoIt.Dijkstra;

import java.util.ArrayList;
import java.util.Scanner;

class Node {
    int idx;
    int cost;

    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }
}

public class Solution3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int start = sc.nextInt();

        //인접리스트 이용한 그래프 초기화
        ArrayList<Node>[] graph = new ArrayList[v+1];

        for(int i = 1; i <= v+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < e; i++){
            //a에서 b로 가는 값, c
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph[a].add(new Node(b, c));
        }

        boolean[] visited = new boolean[v+1];
        int[] dist = new int[v+1];

        for(int i = 1; i <= v; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        //다익스트라 알고리즘 진행
        //모든 노드 방문하면 정료하기 때문에 노드 개수 만큼 반복
        for(int i = 0; i < v; i++){
            // 현재 거리 비용 중 최소인 지점 선택
            int value = Integer.MAX_VALUE;
            int idx = 0;
            for(int j = 1; j <= v; j++){
                if(!visited[j] && dist[j] < value){
                    value = dist[j];
                    idx = j;
                }
            }
            visited[idx] = true;

            for(int j = 0; j < graph[idx].size(); j++){
                Node adj = graph[idx].get(j);
                if(dist[adj.idx] > dist[idx] + adj.cost){
                    dist[adj.idx] = dist[idx] + adj.cost;
                }
            }
        }
        for(int i = 1; i < v +1; i++) {
            if(dist[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(dist[i]);
        }
        sc.close();
    }
}
