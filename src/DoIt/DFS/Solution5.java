package DoIt.DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution5 {
    static boolean visited[];
    static ArrayList<Integer>[] A;
    static boolean arrive;
    public static void main(String[] args) {
        int n;
        int m;
        arrive = false;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        A = new ArrayList[n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            A[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            A[s].add(e);
            A[e].add(s);
        }
        for(int i = 0; i < n; i++){
            DFS(i, 1);
            if(arrive)
                break;
        }
        if(arrive)
            System.out.println("1");
        else
            System.out.println("0");

    }

    public static void DFS(int now, int depth){
        if(depth == 5 || arrive){
            arrive = true;
            return;
        }

        visited[now] = true;
        for(int i : A[now]){
            if(!visited[i]){
                DFS(i, depth + 1);
            }
        }
        visited[now] = false;
    }
}
