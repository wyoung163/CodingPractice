package practice.Dijkstra;
import java.util.*;

/**
 * <배달> summer/winter coding
 *
 * [채점 결과]
 * 정확성: 84.4
 * 합계: 84.4 / 100.0
 */
class Solution {
    static int[] distance;
    static boolean visited[];
    static ArrayList<Edge>[] arr;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        distance = new int[road.length+1];
        visited = new boolean[road.length+1];
        arr = new ArrayList[road.length+1];
        for(int i = 1; i <= road.length; i++){
            arr[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }
        distance[1] = 0;
        for(int i = 0; i < road.length; i++){
            int s = road[i][0];
            int e = road[i][1];
            int w = road[i][2];

            arr[s].add(new Edge(e, w));
            arr[e].add(new Edge(s, w));
        }
        for(int i = 1; i < road.length; i++){
            Dijkstra(i);
        }
        for(int i = 1; i < distance.length; i++){
            if(distance[i] <= K){
                answer++;
            }
        }

        return answer;
    }

    public void Dijkstra(int i){
        for(Edge edge : arr[i]){
            if(distance[edge.e] > distance[i] + edge.w){
                distance[edge.e] = distance[i] + edge.w;
                Dijkstra(edge.e);
            }
        }
        return ;
    }
}

class Edge{
    int e;
    int w;

    public Edge(int e, int w) {
        this.e = e;
        this.w = w;
    }
}