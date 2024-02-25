package DoIt.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//026 DFS + BFS
public class Solution {
    static ArrayList<Integer>[] arr;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); //시작
        arr = new ArrayList[n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s-1].add(e-1);
            arr[e-1].add(s-1);
        }

        for(int i = 0; i < n; i++){
            Collections.sort(arr[i]);
        }
        DFS(k);
        System.out.println();
        visited = new boolean[n];
        BFS(k);
        System.out.println();
    }

    static void DFS(int i){
        System.out.println(i+1 + " ");
        if(visited[i])
            return;

        visited[i] = true;
        for (int v: arr[i]){
            if(!visited[v]) {
                DFS(v);
            }
        }
    }

    static void BFS(int i) {
        Queue<Integer> q = new LinkedList<>();
        visited[i] = true;
        q.add(i);

        while (!q.isEmpty()){
            int n = q.poll();
            System.out.println(n+1 + " ");
            for(int v: arr[n]) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }
}
