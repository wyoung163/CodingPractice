package practice.BFS;

import java.util.*;

/*
    BFS 게임 맵 최단거리
 */
class Solution2 {
    int[][] visited;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int solution(int[][] maps) {
        int answer = 0;

        visited = new int[maps.length][maps[0].length];
        bfs(maps);

        answer = visited[maps.length-1][maps[0].length-1];

        if(answer == 0){
            answer = -1;
        }

        return answer;
    }

    private void bfs(int[][] maps){
        Queue<Edge> queue = new LinkedList<>();
        queue.add(new Edge(0, 0));
        visited[0][0] = 1;

        while(!queue.isEmpty()){
            Edge now = queue.remove();
            for(int i = 0; i < 4; i++){
                int x = now.s + dx[i];
                int y = now.e + dy[i];

                if(x < 0 || x > maps.length-1 || y < 0 || y > maps[0].length-1){
                    continue;
                }

                if(visited[x][y] == 0 && maps[x][y] == 1){
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