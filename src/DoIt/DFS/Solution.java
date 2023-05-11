package DoIt.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//023 연결 요소의 개수 구하기
public class Solution {
    static ArrayList<Integer>[] arr;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        arr = new ArrayList[n];
        for(int i = 0; i < n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            arr[n1-1].add(n2-1);
            arr[n2-1].add(n1-1);
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                cnt++;
                DFS(i);
            }
        }
        System.out.println(cnt);
    }

    static void DFS(int v){
        if(visited[v]){
            //System.out.println("Retutn");
            return;
        }
        visited[v] = true;
        for(int k : arr[v]) {
            if(visited[k] == false) {
                DFS(k);
            }
        }
    }
}
