package DoIt.UnionFind;

import java.util.Scanner;

/*
    050 집합 표현하기
    유니온 파인드 - 조건에 따라 여러 노드를 하나의 집합으로 만드는 과정, 부모가 동일한지 찾아나가기
 */
public class Solution {
    public static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n+1];
        for(int i = 0; i <= n; i++){
            parent[i] = i;
        }
        for(int i = 0; i < m; i++){
            int question = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(question == 0){
                union(a, b);
            } else {
                if(checkSame(a, b)){
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;
        }
    }
    public static int find(int n){
        if(parent[n] == n){
            return n;
        } else {
            return parent[n] = find(parent[n]);
        }
    }
    public static boolean checkSame(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b){
            return true;
        }
        return false;
    }
}
