package DoIt.Dijkstra;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    059 타임머신으로 빨리 가기
    벨만-포드 알고리즘
    음수 가중치 허용 (v-1 반복문 실행 후에도 최단 거리 배열이 UPDATE 되면
    음수 값이 계속 커지면서 사이클이 생김)
    다익스트라와의 차이점 인지하면서 최단 경로 구하기
    시간복잡도 VE로 느림
    모든 노드에 대해 매 반복문마다 모든 간선의 값 확인하여 최단 값 찾음
 */
public class Solution4 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static long distance[];
    static Edges edges[];
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        edges = new Edges[m+1];
        distance = new long[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            edges[i] = new Edges(s, e, t);
        }
        //벨만 - 포드 알고리즘
        distance[1] = 0;
        //시간 복잡도 VE로 좋지 않음
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                Edges edge = edges[i];
                if(distance[edge.start] != Integer.MAX_VALUE
                && distance[edge.end] > distance[edge.start] + edge.time){
                    distance[edge.end] =  distance[edge.start] + edge.time;
                }
            }
        }
        boolean mCycle = false;
        //음수 사이클 확인
        for(int i = 0; i < m; i++){
            Edges edge = edges[i];
            if(distance[edge.start] != Integer.MAX_VALUE
                    && distance[edge.end] > distance[edge.start] + edge.time){
                mCycle = true;
            }
        }
        if(!mCycle){
            for(int i = 2; i <= n; i++){
                if(distance[i] == Integer.MAX_VALUE)
                    System.out.println("-1");
                else
                    System.out.println(distance[i]);
            }
        } else {
            System.out.println("-1");
        }
    }
}

class Edges {
    int start, end, time;

    public Edges(int start, int end, int time) {
        this.start = start;
        this.end = end;
        this.time = time;
    }
}
