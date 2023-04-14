package practice.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2 {
    static int v, e, start;
    static ArrayList<ArrayList<Node>> graph;

    static class Node {
        int idx, weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        graph = new ArrayList<ArrayList<Node>>();

        for(int i = 0; i < v +1; i++){
            graph.add(new ArrayList<Node>());
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e, c));
        }

        int[] dist = new int[v+1];
        for(int i = 0; i < v+1; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        //다익스트라 알고리즘의 최소 비용 기준으로 추출.
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) ->
                Integer.compare(o1.weight, o2.weight));
        q.offer(new Node(start, 0));
        dist[start] = 0;
        while(!q.isEmpty()){
            Node curNode = q.poll();
            //목표 정점이 꺼내 졌다면, 해당 노드까지는 최솟값 갱신이 완료되었다는 것 확정
            //꺼낸 노드 = 현재 최소 비용을 갖는 노드
            //해당 노드의 비용이 현재 dist 배열에 기록된 내용보다 크면 고려할 필요 없음

            if(dist[curNode.idx] < curNode.weight){
                continue;
            }
            //선택된 노드의 모든 주변 노드 고려
            for(int i = 0; i < graph.get(curNode.idx).size(); i++){
                Node nxtNode = graph.get(curNode.idx).get(i);
                if(dist[nxtNode.idx] > curNode.weight + nxtNode.weight) {
                    dist[nxtNode.idx] = curNode.weight + nxtNode.weight;
                    q.offer(new Node(nxtNode.idx, dist[nxtNode.idx]));
                }
            }
        }

        for(int i = 1; i < dist.length; i++) {
            System.out.println(dist[i]);
        }
        System.out.println(Arrays.toString(dist));
    }
}
