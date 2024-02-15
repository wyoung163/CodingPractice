package BaekJoon.Graph.BackTracking;

import java.util.Scanner;

public class Solution {
    public static int n;
    public static int count;
    public static int[] map;

    public static boolean check(int[] map, int col){
        for(int i = 1; i < col; i++){
            if(map[i] == map[col])
                // 같은 열이면 퀸을 배치 못하니 false
                return false;
            if(Math.abs(i - col) == Math.abs(map[i] - map[col]))
                // 서로 대각선에 위치하고 있으면 배치 못함
                return false;
        } return true;
    }

    public static void dfs(int[] map, int col){
        if(col == n){
            count++;
        }
        else {
            for(int i = 1; i <= n; i++){
                map[col+1] = i; // 다음 행의 i열에 퀸을 배치할 수 있는가
                if(check(map, col+1)){
                    dfs(map, col+1);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            map = new int[n+1];
            map[1] = i;
            dfs(map, 1);
        }
        System.out.println(count);

    }
}
