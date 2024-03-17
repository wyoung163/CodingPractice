package BaekJoon.Graph;

public class Solution3 {
    // union-find
    static int[] parent;

    public static boolean union(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y) return false;

        if(x <= y) parent[y] = x;
        else parent[x] = y;
        return true;
    }

    public static int find(int k){
        if(parent[k] == k) return k;
        return find(parent[k]);
    }

    // kruskal
    public static void kruskal(int[][] graph){
        int cost = 0;
        for(int i = 0; i < graph.length; i++){
            if(find(graph[i][0]) != find(graph[i][1])){
                cost += graph[i][2];
                union(graph[i][0], graph[i][1]);
            }
        }
    }
}
