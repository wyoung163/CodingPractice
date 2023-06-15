package DoIt.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    062 케빈 베이컨 6단계 법칙
    BFS, 모든 시작점을 기준으로 BFS 수행
    각 시작점에 대해 특정 점을 기준으로 갈 수 있는 모든 경로 확인하기
 */
public class Solution4 {
    static int arr[][];
    static boolean visit[];

    static int n;
    static int result;
    static int min_cnt = Integer.MAX_VALUE;

    static class Bacon {
        int num;
        int value;

        public Bacon(int num, int value) {
            this.num = num;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 유저의 수
        int M = Integer.parseInt(st.nextToken()); // 친구 관계의 수

        arr = new int[n+ 1][n + 1];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[y][x] = 1;
            arr[x][y] = 1;
        }


        for(int i=1; i<=n; i++) {
            visit = new boolean[n + 1];
            BFS(i);
        }

        System.out.println(result);

    }

    static void BFS(int start){
        Queue<Bacon> queue = new LinkedList<>();
        int cnt = 0;

        visit[start] = true;
        queue.offer(new Bacon(start, 0));

        while(!queue.isEmpty()){
            Bacon bacon = queue.poll();
            cnt = bacon.value;

            for(int i = 1; i <= n; i++){
                //bacon.num으로 시작하는 경로 어디든 갈 수 있음
                int num = arr[bacon.num][i];

                //num == 1일 때, 연결된 경로임을 의미
                if(num == 1 && visit[i] == false){
                    visit[i] = true;
                    queue.offer(new Bacon(i, bacon.value + 1));
                }
            }
        }

        if(min_cnt > cnt) {
            min_cnt = cnt;
            result = start;
        }

    }
}

