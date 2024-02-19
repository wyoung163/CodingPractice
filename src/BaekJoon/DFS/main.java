package BaekJoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class main {
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    static int cnt, depth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        arr = new ArrayList[n+1];
        for(int i = 1; i < n+1; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }
        visited = new boolean[n+1];
        cnt = 0;
        if(arr[1].isEmpty()) cnt = 0;
        else {
            dfs(1, 0);
        }

        for(int i = 2; i < n+1; i++){
            if(visited[i]) cnt++;
        }
        System.out.println(cnt);
    }

    static public void dfs(int n, int d){
        if(d == 2){
            return;
        }
        visited[n] = true;

        for(int i : arr[n]){
            //if(visited[i]) continue;
            visited[i] = true;

            dfs(i, d+1);
        }
    }
}
