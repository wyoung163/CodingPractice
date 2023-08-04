package DoIt.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
    023
    DFS 베이직 문제
    방문한 노드가 없을 떄까지 반복문 돌리는 부분 유의하기
 */
public class Solution4 {
    static ArrayList<Integer>[] arrayList;
    static boolean visited[];
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arrayList = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            arrayList[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arrayList[s].add(e);
            arrayList[e].add(s);
        }
        cnt = 0;
        visited = new boolean[n+1];
        for(int i = 0; i < n; i++){
            if(!visited[i]) {
                cnt++;
                DFS(i);
            }
        }

        System.out.println(cnt);
    }

    static void DFS(int i){
        if(visited[i]) return;
        visited[i] = true;

        for(int j: arrayList[i]){
            if(!visited[j]) {
                DFS(j);
            }
        }
    }
}
