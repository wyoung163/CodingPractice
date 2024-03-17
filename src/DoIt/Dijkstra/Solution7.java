package DoIt.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution7 {
    static public int n, m, start, end;
    static public ArrayList<ArrayList<Node>> map;
    static int[] distance;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new ArrayList<>();
        for(int i = 0; i < n; i++){
            map.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            map.get(a).add(new Node(b, l));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        distance = new int[n+1];
        visited = new boolean[n+1];
        dijkstra(start);
        System.out.println(distance[end]);
    }

     static void dijkstra(int start){
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Node> queue = new PriorityQueue<>(((o1, o2) -> o1.len - o2.len));
        queue.add(new Node(start, 0));
        distance[start] = 0;

        while(!queue.isEmpty()){
            Node now = queue.poll();

            if(!visited[now.d]){
                visited[now.d] = true;
                for(Node node : map.get(now.d)){
                    if(distance[node.d] > distance[now.d] + node.len){
                        distance[node.d] = distance[now.d] + node.len;
                        queue.add(new Node(node.d, distance[node.d]));
                    }
                }
            }
        }
    }

    static void solution(int start){
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>(((o1, o2) -> o1.len - o2.len));
        queue.add(new Node(start, 0));

        while(!queue.isEmpty()){
            Node now = queue.poll();

            if(!visited[now.d]) {
                visited[now.d] = true;
                for (Node node : map.get(now.d)) {
                    if (distance[node.len] > distance[now.d] + node.len) {
                        distance[node.len] = distance[now.d] + node.len;
                        queue.add(new Node(node.d, distance[node.d]));
                    }
                }
            }
        }
    }

    static class Node{
        int d;
        int len;

        Node(int d, int len){
            this.d = d;
            this.len = len;
        }
    }
}
