package practice.DivideIntoTwo;

import java.util.*;

//DFS BFS 모두 가능
//주어진 wires에서 하나의 사례가 해당하지 않는 사례로 만들어(전선을 끊어) 연결된 송전탑 개수 구하기
//참고: https://arinnh.tistory.com/84
//출처: https://velog.io/@minsang96/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Level2-%EC%A0%84%EB%A0%A5%EB%A7%9D%EC%9D%84-%EB%91%98%EB%A1%9C-%EB%82%98%EB%88%84%EA%B8%B0-Java
class Solution {
    ArrayList<Integer>[] arrs;
    boolean[] visited;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE/2;
        arrs = new ArrayList[n];
        for(int i = 0; i < n; i++){
            arrs[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < wires.length; i++){
            arrs[wires[i][0]-1].add(wires[i][1]-1);
            arrs[wires[i][1]-1].add(wires[i][0]-1);
        }

        for(int i = 0; i < wires.length; i++){
            int v1 = wires[i][0]-1;
            int v2 = wires[i][1]-1;

            visited = new boolean[n];
            visited[0] = true;

            dfs(0, v1, v2);

            int cnt = 0;
            for(int j = 0; j < visited.length; j++){
                if(visited[j]) cnt++;
            }

            answer = Math.min(answer, Math.abs(n-2*cnt));
        }

        return answer;
    }

    private void dfs(int n, int v1, int v2){
        for(int num: arrs[n]){
            //연결된 선을 끊는
            if((n == v1 && num == v2) || (n == v2 && num == v1)) continue;
            if(!visited[num]){
                System.out.println(n + " " + v1 +" " +  num + " " + v2);

                visited[num] = true;
                dfs(num, v1, v2);
            }
        }
    }
}