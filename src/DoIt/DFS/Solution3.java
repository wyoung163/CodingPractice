package DoIt.DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution3 {
    static boolean visited[];
    static ArrayList<Integer>[] arr;
    static boolean arrive;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        arrive = false;
        arr = new ArrayList[n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            int s = scan.nextInt();
            int e = scan.nextInt();
            arr[s].add(e);
            arr[e].add(s);
        }

        for(int i = 0; i < n; i++){
            DFS(i, 1);
            if(arrive)
                break;
        }

        if(arrive) System.out.println("1");
        else System.out.println("0");
    }

    public static void DFS(int now, int depth){
        if(depth == 5 || arrive){
            arrive = true;
            return;
        }
        visited[now] = true;
        for(int k: arr[now]){
            if(!visited[k]){
                DFS(k, depth+1);
            }
        }
        //DFS의 결과가 depth가 5가 아닌 경우 다른 경우의 수를 따져야 하기 때문에
        visited[now] = false;
    }
}
