package DoIt.MinimumSpanningTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    065 최소 신장 트리
 */
public class Solution2 {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[] parent;
    static int[][] map;
    static int n, m, sNum;
    static boolean[][] visited;
    static ArrayList<ArrayList<int[]>> sumlist; // 모든 섬 정보
    static ArrayList<int[]> mlist; // 한 섬 정보
    static PriorityQueue<bEdge> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; i < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sNum = 1;
        sumlist = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; i < m; j++){
                if(map[i][j] != 0 && visited[i][j] != true){
                    BFS(i, j);
                    sNum++;
                    sumlist.add(mlist);
                }
            }
        }
        queue = new PriorityQueue<bEdge>();
        for(int i = 0; i < sumlist.size(); i++) {
            ArrayList<int[]> now = sumlist.get(i);
            for(int j = 0; j < now.size(); j++){
                int r = now.get(j)[0];
                int c = now.get(j)[1];
                int now_s = map[r][c];
                for(int d = 0; d < 4; d++){
                    int tempR = dr[d];
                    int tempC = dc[d];
                    int blength = 0;
                    while(r + tempR >= 0 && r + tempR < n && c + tempC >= 0 && c + tempC < m){
                        if(map[r+tempR][c+tempC] == now_s) // 같은 섬이면 패스
                            break;
                        else if(map[r+tempR][c+tempC] != 0){ //같은 섬도 아니고 바다도 아니라면
                            if(blength > 1) //다른 섬 -> 길이가 1 이상일 때 에지로
                                queue.add(new bEdge(now_s, map[r+tempR][c+tempC], blength));
                            break;
                        } else //바다라면 다리의 길이 연장
                            blength++;
                        // 계속 같은 방향을 유지하기 위한 코드
                        if(tempR < 0) tempR--;
                        else if(tempR > 0) tempR++;
                        else if(tempC < 0) tempC--;
                        else if(tempC > 0) tempC++;
                    }
                }
            }
        }
        parent = new int[sNum];
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
        int useEdge = 0;
        int result = 0;
        while(!queue.isEmpty()){
            bEdge now = queue.poll();
            if(find(now.s) != find(now.e)){
                union(now.s, now.e);
                result = result + now.v;
                useEdge++;
            }
        }
        if(useEdge == sNum -2){
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            parent[b] = a;
        }
    }

    public static int find(int a){
        if(a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);
    }
    private static void BFS(int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        mlist = new ArrayList<>();
        int[] start = { i, j};
        queue.add(start);
        mlist.add(start);
        visited[i][j] = true;
        map[i][j] = sNum;
        while(!queue.isEmpty()){
            int now[] = queue.poll();
            int r = now[0];
            int c = now[1];
            for(int d = 0; d < 4; d++){
                int tempR = dr[d];
                int tempC = dc[d];
                while(r + tempR >= 0 && r + tempR < n && c + tempC >= 0 && c + tempC < m){
                    // 방문한 적 없고 바다가 아니면 같은 섬으로
                    if(visited[r+tempR][c+tempC] == false && map[r+tempR][c+tempC] != 0){
                        addNode(r+tempR, c+tempC, queue);
                    } else break;
                    if(tempR < 0) tempR--;
                    else if(tempR > 0) tempR++;
                    else if(tempC < 0) tempC--;
                    else if(tempC > 0) tempC++;
                }
            }
        }
    }
    private static void addNode(int i, int j, Queue<int[]> queue){
        map[i][j] = sNum;
        visited[i][j] = true;
        int[] temp = { i, j};
        mlist.add(temp);
        queue.add(temp);
    }
}
class bEdge implements Comparable<bEdge>{
    int s, e, v;

    public bEdge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }

    @Override
    public int compareTo(bEdge o) {
        return this.v - o.v;
    }
}
