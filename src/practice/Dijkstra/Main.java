package practice.Dijkstra;

import javax.swing.text.DefaultStyledDocument;
import java.util.ArrayList;
import java.util.Scanner;

class Node {
    int idx;
    int weight;

    public Node(int idx, int weight) {
        this.idx = idx;
        this.weight = weight;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt(); //노드 수
        int e = scanner.nextInt(); //긴선 수
        int start = scanner.nextInt();

        //인전리스트를 이용한 그래프 초기화
        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

        for(int i = 0; i < v+1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int w = scanner.nextInt();

            graph.get(a).add(new Node(b, w));
        }

        //방문 여부 확인
        boolean[] visited = new boolean[v+1];
        //start부터 end까지 최소 거리 저장
        int[] dist = new int[v+1];

        for(int i = 0; i < v+1; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        //출발지 weight = 0
        dist[start] = 0;

        //다익스트라 알고리즘 진행
        // 모든 노드 방문하면 종료되기 때문에 노드 수만큼 반복
        for(int i = 0; i < v; i++){
            int nodeValue = Integer.MAX_VALUE;
            int nodeIdx = 0;
            for(int j = 0; j < v+1; j++){
                //방문하지 않았고 현재 모든 거리 비용 중 최솟값 찾기
                if(!visited[j] && dist[j] < nodeValue){
                    nodeValue = dist[j];
                    nodeIdx = j;
                }
            }
            visited[nodeIdx] = true;

            //해당 지점을 기준으로 인접 노드의 최소 거리 값 갱신
            for(int j = 0; j < graph.get(nodeIdx).size(); j++){
                //인전 노드 선택
                Node adjNode = graph.get(nodeIdx).get(j);
                //인전노드가 현재 가지는 최소 비용과 현재 선택된 노드 값 + 인전노드로 가는 값을 비교하여 더 작은 값 갱신
                if(dist[adjNode.idx] > dist[nodeIdx] + adjNode.weight){
                    dist[adjNode.idx] = dist[nodeIdx] + adjNode.weight;
                }
            }
        }
        for(int i = 1; i < v+1; i++){
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }
            else {
                System.out.println(dist[i]);
            }
        }
        scanner.close();;


    }
}
