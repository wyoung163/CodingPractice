package practice.DFS;

import java.util.*;

class Solution2 {
    static ArrayList<Integer>[] arr;
    static boolean visited[];
    static int answer = 0;

    public int solution(int n, int[][] computers) {
        arr = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(computers[i][j] == 1 && i != j){
                    arr[i+1].add(j+1);
                    arr[j+1].add(i+1);
                }
            }
        }
        visited = new boolean[n+1];

        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                DFS(i);
                answer++;
            }
        }

        return answer;
    }

    private void DFS(int i){
        visited[i] = true;

        for(int n : arr[i]){
            if(!visited[n]) {
                visited[n] = true;
                DFS(n);
            }
        }
    }
}