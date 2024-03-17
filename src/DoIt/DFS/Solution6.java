package DoIt.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution6 {
    public static int n;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx= new int[]{-1, 1, 0, 0};
    public static int[] dy = new int[]{0, 0, -1, 1};
    public static int answer = 0;
    public static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        int maxHeight = 0;
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > maxHeight)
                    maxHeight = map[i][j];
            }
        }

        for(int h = 1; h < maxHeight+1; h++) {
            visited = new boolean[n + 1][n + 1];
            answer = 0;

            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (map[i][j] > h && !visited[i][j]) {
                        answer += dfs(i, j, h);
                    }
                }
            }
            max = Math.max(max, answer);
        }
        System.out.println(max);
    }
    public static int dfs(int x, int y, int h){
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx <= 0 || ny <= 0 || nx > n || ny > n) continue;
            if(visited[nx][ny]) continue;
            if(map[nx][ny] > h){
                dfs(nx, ny, h);
            }
        }
        return 1;
    }
}
