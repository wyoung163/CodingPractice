package DoIt.Graph;

import java.util.*;

/*
    046 특정 거리의 도시 찾기
    최단거리지만 BFS 이용
    visited[]를 거리로 활용
 */
public class Solution {
    static int visited[];
    static ArrayList<Integer>[] arr;
    static int n, m, k, x;
    static List<Integer> answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        x = sc.nextInt();
        answer = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr[s].add(e);
        }
        visited = new int[n+1];
        for(int i = 0; i <= n; i++){
            visited[i] = -1;
        }
        BFS(x);
        for(int i = 0; i <= n; i++){
            if(visited[i] == k){
                answer.add(i);
            }
        }
        if(answer.isEmpty()){
            System.out.println("-1");
        } else{
            Collections.sort(answer);
            for(int i: answer){
                System.out.println(i);
            }
        }


    }
    private static void BFS(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node]++;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i : arr[now]){
                if(visited[i] == -1){
                    visited[i] = visited[now] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
