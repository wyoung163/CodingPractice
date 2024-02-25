package practice.ExhautiveSearch;

public class Solution2 {
    public static int[][] map;
    public static int s_x, s_y, i_x, i_y;
    public static int[][] res;
    public static boolean[][] visited;
    public static int[] dx = {0, -1, 1, 0};
    public static int[] dy = {1, 0, 0, -1};

    public static void main(String[] args) {
        solution();
    }
    public static int solution() {
        int answer = 0;
        int[][] rectangle = {{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}};
        map = new int[51][51];
        for(int i = 0; i < rectangle.length; i++){
            int r = rectangle[i][0];
            int c = rectangle[i][1];
            int r2 = rectangle[i][2];
            int c2 = rectangle[i][3];

            for(int j = r; j <=r2; j++){
                map[j][c] = 1;
                map[j][c2] = 1;
            }

            for(int j = c; j <= c2; j++){
                map[r][j] = 1;
                map[r2][j] = 1;
            }

        }
        s_x = 6;
        s_y = 1;
        i_x = 9;
        i_y = 7;
        res = new int[51][51];
        visited = new boolean[51][51];
        search(s_x, s_y, 1);
        answer = map[i_x][i_y];
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                System.out.print(map[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println(answer);
        return answer;
    }

    public static void search(int s_x, int s_y, int depth){
        if(map[s_x][s_y] == 0 || visited[s_x][s_y]) return;

        visited[s_x][s_y] = true;

        for(int i = 0; i < 4; i++){
            int x = s_x + dx[i];
            int y = s_y + dy[i];
            if(x >= 0 && x < 51 && y >=0 && y < 51){
                if(map[x][y] != 0 && !visited[x][y]){
                    map[x][y] = depth + 1;
                    search(x, y, depth +1);
                }
            }
        }
    }

}
