package DoIt.Floyd;

import java.io.*;
import java.util.StringTokenizer;

/*
    062 경로 찾기
    특정 k 지점을 거쳐가서라도 경로가 존재하는지 여부를 확인
    플로이드 - 위셜의 변형 활용
 */
public class Solution2 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int distance[][];
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        distance = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int v = Integer.parseInt(br.readLine());
                distance[i][j] = v;
            }
        }
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(distance[i][k] == 1 && distance[k][j] == 1){
                        distance[i][j] = 1;
                    }
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.println(distance[i][j] + " ");
            }
            System.out.println();
        }

    }
}
