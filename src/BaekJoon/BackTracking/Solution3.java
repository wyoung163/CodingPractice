package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// solution2와 달리 같은 수를 여러 번 골라도 됨
public class Solution3 {
    static int n, m;
    static int[] num;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        num = new int[n];
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
            if(before != num[i]){
                answer[depth] = num[i];
                before = num[i];
                dfs(depth+1);
            }
        }
    }
}
