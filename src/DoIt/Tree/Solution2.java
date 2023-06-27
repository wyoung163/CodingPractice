package DoIt.Tree;

import java.util.ArrayList;
import java.util.Scanner;

/*
    068 리프노드 개수 구하기, DFS(자식의 수를 고려하는 변수 이용)
 */
public class Solution2 {
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    static int rm;
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        visited = new boolean[n];
        rm = sc.nextInt();
        arr = new ArrayList[n];
        int root = 0;
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            if(tmp != -1) {
                arr[i].add(tmp);
                arr[tmp].add(i);
            } else {
                root = i;
            }
        }
        if(rm == root)
            System.out.println(0);
        else {
            DFS(root);
            System.out.println(answer);
        }
    }
    static void DFS(int i){
        visited[i] = true;
        int cur = 0; // 자식의 수를 세기 위한
        for(int n : arr[i]){
            if(visited[n] == false && n != rm){
                cur++;
                DFS(n);
            }
        }
        if(cur == 0){
            answer++;
        }
    }
}
