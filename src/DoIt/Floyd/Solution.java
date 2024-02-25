package DoIt.Floyd;

import java.io.*;
import java.util.StringTokenizer;

/*
    Problem 061 가장 빠른 버스 노선 구하기
    플로이드-위셜 최단거리 알고리즘
    v의 3제곱으로 효율 떨어지나, 노드 대수 범위가 다른 그래프에 적게 나타남
 */
public class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int distance[][];
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        distance = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j)
                    distance[i][j] = 0;
                else
                    distance[i][j] = 10000001;
            }
        }
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(distance[s][e] > v) distance[s][e] = v;
        }
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(distance[i][j] > distance[i][k] + distance[k][j]){
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
        for(int i =1; i <=n; i++){
            for(int j =1; j <= n; j++){
                if(distance[i][j] == 10000001) System.out.println("0 ");
                else System.out.println(distance[i][j] + " ");
            }
            System.out.println();
        }
    }
}
