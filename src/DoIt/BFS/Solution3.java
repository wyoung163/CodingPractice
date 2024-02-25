package DoIt.BFS;

import java.util.*;

public class Solution3 {
    static boolean visited[];
    static int[] distance;
    static ArrayList<Edge>[] A;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        A = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            A[i] = new ArrayList<Edge>();
        }
        for(int i = 0; i < n; i++){
            int s = sc.nextInt();
            while(true) {
                int e = sc.nextInt();
                if(e == -1){
                    break;
                }
                int v = sc.nextInt();
                A[s].add(new Edge(e, v));
            }
        }

        distance = new int[n+1];
        visited = new boolean[n+1];
        BFS(1);
        int max = 1;
        for(int i = 2; i <= n; i++){
            if(distance[max] < distance[i])
                max = i;
        }
        distance = new int[n+1];
        visited = new boolean[n+1];
        BFS(max);
        Arrays.sort(distance);
        System.out.println(distance[n]);
    }

    private static void BFS(int idx){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        visited[idx] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(Edge i : A[now]){
                int e = i.e;
                int v = i.v;
                if(!visited[e]){
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[now] + v;
                }
            }
        }
    }
    static class Edge {
        int e;
        int v;

        public Edge(int e, int v) {
            this.e = e;
            this.v = v;
        }
    }
}
