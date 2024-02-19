package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2 {
    static int n, m;
    static int[] num;
    static boolean[] visit;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        num = new int[n];
        visit = new boolean[n];
        answer = new int[m];
        for(int i = 0; i < n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        dfs(0);
    }
    static void dfs(int depth){
        if(depth == m){
            for(int val: answer){
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        int before = 0;
        for(int i = 0; i < n; i++){
            if(!visit[i] && before != num[i]){
                visit[i] = true;
                answer[depth] = num[i];
                before = num[i];
                dfs(depth+1);
                visit[i] = false;
            }
        }
    }
}
