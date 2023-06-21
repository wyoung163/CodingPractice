package DoIt.Tree;

import java.util.ArrayList;
import java.util.Scanner;

/*
    068 리프 노드의 개수 구하기
    DFS(되돌아가는 return 코드 없음)
    트리의 구조와 개념 이해
 */
public class Solution {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int answer = 0;
    static int deleteNode = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        tree = new ArrayList[n];
        int root = 0;
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++){
            int p = sc.nextInt();
            if (p != -1){
                tree[i].add(p);
                tree[p].add(i);
            } else
                root = i;
        }
        deleteNode = sc.nextInt();
        if(deleteNode == root)
            System.out.println(0);
        else {
            DFS(root);
            System.out.println(answer);
        }
    }
    static void DFS(int num){
        visited[num] = true;
        int cNode = 0;
        for(int i : tree[num]){
            if(visited[i] == false && i != deleteNode){
                cNode++;
                DFS(i);
            }
        }
        if(cNode == 0){
            answer++; // 자식 노드 아닐 때 리프 노드로 간주하고 정답값 증가
        }
    }
}
