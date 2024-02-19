package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class cabbage {
    static int map[][];
    static boolean [][] visited;
    static int t, m, n, k;
    static int[] rx = {0, 0, -1, 1}, ry = {1, -1, 0, 0};
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for(int re = 0; re < t; t++) {
            answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[m][n];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                map[r][c] = 1;
            }

            visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }
    }

    static void bfs(int a, int b){
        queue.add(new int[] {a, b});
        visited[a][b] = true;

        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int px = tmp[0];
            int py = tmp[1];

            visited[px][py] = true;

            for(int i = 0; i < 4; i++){
                int nx = px + rx[i];
                int ny = py + ry[i];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n){
                    if(!visited[nx][ny] && map[nx][ny] == 1){
                        queue.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
