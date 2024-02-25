package practice.Dijkstra;

import java.util.*;

/**
 * 배달
 * 우선순위 큐를 활용한 다익스트라 알고리즘으로 런타임 에러 해결
 */
class Solution2
{
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] dist = new int[N+1];
        int[][] graph = new int[N+1][N+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[0], o2[0]);
        });

        for(int i = 0; i < N+1; i++){
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < road.length; i++){
            int s = road[i][0];
            int e = road[i][1];
            int w = road[i][2];
            if(graph[s][e] > w){
                graph[s][e] = w;
                graph[e][s] = w;
            }
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        dijkstra(pq, graph, 1, dist);
        for(int i = 1; i <= N; i++){
            if(dist[i] <= K)
                answer++;
        }
        return answer;
    }

    public void dijkstra(PriorityQueue<int[]> pq, int[][] graph, int s, int[] dist){
        dist[s] = 0;
        pq.add(new int[]{dist[s], s});

        while(!pq.isEmpty()){
            int[] pop = pq.remove();
            int pop_s = pop[1];
            int pop_w = pop[0];

            for(int i = 1; i < graph.length; i++){
                int end_d = graph[pop_s][i];
                if(end_d != Integer.MAX_VALUE){
                    if(dist[i] > dist[pop_s] + end_d){
                        dist[i] = dist[pop_s] + end_d;
                        pq.add(new int[]{dist[i], i});
                    }
                }

            }
        }
    }
}
