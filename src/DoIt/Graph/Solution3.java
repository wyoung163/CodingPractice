package DoIt.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
   048 이분 그래프 판별하기
   깊이 우선 탐색을 모든 노드에 대해 탐색하는 이유 유의

 */
public class Solution3 {
    static ArrayList<Integer>[] section;
    static int[] check;
    static boolean visited[];
    static boolean isEven;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String[] s = br.readLine().split(" ");
            int v = Integer.parseInt(s[0]); //노드 개수
            int e = Integer.parseInt(s[1]); //엣지 개수
            section = new ArrayList[v+1];
            visited = new boolean[v+1];
            check = new int[v+1];
            isEven = true;
            for(int j = 0; j < e; j++){
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                section[start].add(end);
                section[end].add(start);
            }
            for(int j = 1; j <= v; j++){
                if(isEven)
                    DFS(i); //모든 노드에 대해 탐색하는 이유는 여러 개로 나누어진 부분 그래프로 구성될 수도 있기 때문
                else
                    break;
            }
            check[1] = 0;
            if(isEven)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    public static void DFS(int node){
        visited[node] = true;
        for(int i : section[node]){
            if(!visited[i]){
                check[i] = (check[node] + 1) % 2;
                DFS(i);
            }
            else if(check[node] == check[i]){
                isEven = false;
            }
        }
    }
}
