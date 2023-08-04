package DoIt.Floyd;

import java.io.*;
import java.util.StringTokenizer;

/*
    063 케빈 베이컨의 6단계 법칙
    BFS도 가능하나 N이 작아서 플로이드-위셜로도 해결 가능
 */
public class Solution3 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m;
    static int distance[][];

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
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
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            distance[s][e] = 1;
            distance[e][s] = 1;
        }
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(distance[i][k] + distance[k][j] < distance[i][j])
                        distance[i][j] = distance[i][k] + distance[k][j];
                }
            }
        }
        int Min = Integer.MAX_VALUE;
        int answer = -1;
        for(int i = 1; i <= n; i++){
            int temp = 0;
            for(int j = 1; j <= n; j++){
                temp = temp + distance[i][j];
            }
            if(Min > temp) {
                Min = temp;
                answer = i;
            }
        }
        System.out.println(answer);
    }
}
