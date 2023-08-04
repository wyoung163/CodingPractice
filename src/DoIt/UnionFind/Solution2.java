package DoIt.UnionFind;

import java.util.ArrayList;
import java.util.Scanner;

/*
    051 여행 계획 짜기
    유니온-파인드인지 바로 떠오르지 않아 어려웠던 문제
 */
public class Solution2 {
    static int[][] arr;
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //총 도시 수
        int m = sc.nextInt(); //방문하고자 하는 도시 수
        arr = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int[] route = new int[m+1];
        for(int i = 1; i <= m; i++){
            route[i] = sc.nextInt();
        }
        parent = new int[n+1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(arr[i][j] == 1) union(i, j);
            }
        }
        int idx = find(route[1]);
        for(int i = 2; i < route.length; i++){
            if(idx != find(route[i])){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            parent[b] = a;
        }
    }
    public static int find(int a){
        if(a == parent[a]){
            return a;
        } else{
            return parent[a] = find(parent[a]);
        }
    }
}
