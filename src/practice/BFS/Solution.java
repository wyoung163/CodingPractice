package practice.BFS;
import java.util.*;

class Solution {
    int[][] visited;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int solution(int[][] maps) {
        int answer = 0;

        visited = new int[maps.length+1][maps[0].length+1];
        bfs(maps);

        answer = visited[maps.length][maps.length];

        if(answer == 0){
            answer = -1;
        }

        return answer;
    }

    private void bfs(int[][] maps){
        Queue<Edge> queue = new LinkedList<>();
        queue.add(new Edge(1, 1));
        visited[1][1] = 1;

        while(!queue.isEmpty()){
            Edge now = queue.poll();
            for(int i = 0; i < 4; i++){
                int x = now.s + dx[i];
                int y = now.e + dy[i];
                //if문이 왜 잘못되었는지 고민해보기
                if(x >= 1 && x <= maps.length && y >=1 && y <= maps.length){
                    if(visited[x][y] == 0 && maps[x-1][y-1] == 1){
                        visited[x][y] = visited[now.s][now.e] + 1;
                        queue.add(new Edge(x, y));
                    }
                }
            }
        }
    }

    class Edge {
        int s;
        int e;

        public Edge(int s, int e){
            this.s = s;
            this.e = e;
        }
    }
}