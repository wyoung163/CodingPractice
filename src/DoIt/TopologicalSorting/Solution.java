package DoIt.TopologicalSorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    053 줄 세우기
    위상정렬(순서가 있지만 사이클은 없는 그래프)
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= n; i++){
            A.add(new ArrayList<>());
        }
        int[] indegree = new int[n+1]; //진입차수
        for(int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            A.get(s).add(e);
            indegree[e]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int now = queue.poll();
            System.out.println(now + " ");
            for(int next: A.get(now)){
                indegree[next]--;
                if(indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }
    }
}
