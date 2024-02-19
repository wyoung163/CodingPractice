package DoIt.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int arr[][] = new int[n+1][n+1];
        for(int i = 1; i < n+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < n+1; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int q[][] = new int[m][4];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++){
                q[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int D[][] = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                 if(i == 1){
                     if(j == 1) D[i][j] = arr[i][j];
                     else D[i][j] = D[i][j-1] + arr[i][j];
                 } else if (j == 1){
                     D[i][j] = D[i-1][j] + arr[i][j];
                 } else {
                     D[i][j] = D[i-1][j] + D[i][j-1] - D[i-1][j-1] + arr[i][j];
                 }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(D[i+1][j+1]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
