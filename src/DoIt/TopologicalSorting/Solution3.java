package DoIt.TopologicalSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    055 임계 경로 구하기
    위상 정렬
 */
public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Node>> A = new ArrayList<>();
        ArrayList<ArrayList<Node>> reverse = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            A.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }
        int[] indegree = new int[n+1];
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            A.get(s).add(new Node(e, v));
            reverse.get(e).add(new Node(s, v));
            indegree[e]++;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        // 위상 정렬
        // 출발, 도착 도시가 주어지기 때문에 일반적인 위상 정렬이 아닌 시작점을 출발 도시로 지정하고 위상 정렬 수행하면
        // 출발 도시에서 도착 도시까지 거치는 모든 도시 관련 임계 경로값 알 수 있음
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int[] result = new int[n+1];
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(Node next: A.get(now)){
                indegree[next.targetNode]--;
                result[next.targetNode] = Math.max(result[next.targetNode], result[now] + next.value);
                if(indegree[next.targetNode] == 0){
                    queue.offer(next.targetNode);
                }
            }
        }
        // 위상 정렬 reverse
        int resultCnt = 0;
        boolean visited[] = new boolean[n+1];
        queue = new LinkedList<>();
        queue.offer(end);
        visited[end] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(Node next: reverse.get(now)){
                //1분도 쉬지 않는 도로 체크
                if(result[next.targetNode] + next.value == result[now]){
                    resultCnt++;
                    //중복 방지를 위해 이미 방문한 적 있는 노드 제외
                    if(visited[next.targetNode] == false){
                        visited[next.targetNode] = true;
                        queue.offer(next.targetNode);
                    }
                }
            }
        }
        System.out.println(result[end]);
        System.out.println(resultCnt);
    }
}
 class Node {
    int targetNode;
    int value;

     public Node(int targetNode, int value) {

         this.targetNode = targetNode; //임계 경로값
         this.value = value;
     }
 }