package DoIt.Graph;

import javax.swing.text.View;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    047 효울적으로 해킹하기
    각 인덱스를 시작점으로 BFS 타고 들어가서
    각 인데스별로 시작점으로부터의 깊이의 총합 구하기
 */
public class Solution2 {
    static int n, m;
    static int answer[];
    static boolean visited[];
    static ArrayList<Integer> A[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            A[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
        }
        for(int i = 1; i <= n; i++){
            visited = new boolean[n+1];
            BFS(i);
        }
        int max = 0;
        for(int i = 1; i <= n; i++){
            max = Math.max(max,answer[i]);
        }
        for(int i = 1; i <= n; i++){
            if(answer[i] == max){
                System.out.println(i + " ");
            }
        }
    }
    public static void BFS(int idx){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        visited[idx] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i : A[now]){
                if(visited[i] == false){
                    visited[i] = true;
                    answer[i]++;
                    queue.add(i);
                }
            }
        }
    }
}
