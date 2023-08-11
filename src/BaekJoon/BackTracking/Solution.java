package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n, m;
    static boolean[] visit;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[n];
        arr = new int[m];
        dfs(0);
    }

    public static void dfs(int depth){
        if(depth == m){
            for(int val : arr){
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < n; i++){
            if(visit[i] == false){
                visit[i] = true;
                arr[depth] = i+1;
                dfs(depth+1);

                visit[i] = false;
            }
        }
        return;
    }
}
