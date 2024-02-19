package DoIt.Dijkstra;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    Problem060 세일즈맨의 고민
    벨만-포드 알고리즘 원리 바탕(최단거리 구하기 -> 도착 도시에 도착할 때 돈의 액수 최대화 하는 방향으로 distance 값 update)
    돈을 무한히 많이 버는 양수 사이클 찾기
    출발 노드에서 양수 사이클을 이용해 도착 도시 못하는 예외 사항 - 에지 업데이트를 도시 수보다 충분히 많이
    => 양수 사이클에서 도달할 수 있는 모든 노드를 양수 사이클에 연결된 노드로 업데이트
 */
public class Solution5 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, sCity, eCity;
    static long distance[], cityMoney[];
    static Edge edges[];
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        sCity = Integer.parseInt(st.nextToken());
        eCity = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        edges = new Edge[m];
        distance = new long[n];
        cityMoney = new long[n];
        Arrays.fill(distance, Long.MIN_VALUE);
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, price);
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            cityMoney[i] = Long.parseLong(st.nextToken());
        }
        distance[sCity] = cityMoney[sCity]; //변형된 벨만-포드 알고리즘
        //양수 사이클 전파되도록 충분히 큰 수 반복
        for(int i = 0; i <= n + 100; i++){
            for(int j = 0; j < m; j++){
                int start = edges[j].start;
                int end = edges[j].end;
                int price = edges[j].price;
                // 출발 노드가 방문하지 않은 노드면 skip
                if(distance[start] == Long.MIN_VALUE) continue;
                // 출발 노드가 양수 사이클에 연결된 노드라면 종료 노드도 연결 노드로 update
                else if(distance[start] == Long.MIN_VALUE)
                    distance[end] = Long.MAX_VALUE;
                // 더 많은 돈을 벌 수 있는 새로운 경로가 있다면 새로운 경로값으로 update
                else if (distance[end] < distance[start] + cityMoney[end] - price){
                    distance[end] = distance[start] + cityMoney[end] - price;
                    // n-1번 반복 이후에도 업데이트되는 종료 노드는 양수 사이클 노드로 변경
                    if(i >= n-1) distance[end] = Long.MAX_VALUE;
                }
            }
        }
        if(distance[eCity] == Long.MIN_VALUE) System.out.println("gg");
        // 양수 사이클 연결돼 무한대 돈을 벌 수 있을 때
        else if(distance[eCity] == Long.MAX_VALUE) System.out.println("Gee");
        else System.out.println(distance[eCity]);
    }

    static class Edge {
        int start, end, price;

        public Edge(int start, int end, int price) {
            this.start = start;
            this.end = end;
            this.price = price;
        }
    }
}
