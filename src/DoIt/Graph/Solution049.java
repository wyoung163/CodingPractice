package DoIt.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    049 물의 양 구하기
    BFS
    완전 탐색이니 깊이 우선 탐색도 가능하지 않을까, 왜 BFS로 선택하셨을까에 대한 궁금증 발생
 */
public class Solution049 {
    //동서남북 방향 이동과 동일한 원리
    static int[] send = {0, 0, 1, 1, 2, 2}; //여러가지 방향으로의 이동
    static int[] receive = {1, 2, 0, 2, 0, 1}; //여러가지 방향으로의 이동
    static boolean visited[][];
    static boolean answer[];
    static int now[];
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        now[0] = sc.nextInt();
        now[1] = sc.nextInt();
        now[2] = sc.nextInt();
        visited = new boolean[201][201];
        answer = new boolean[201];
        BFS();
        for(int i = 0; i < answer.length; i++) {
            if(answer[i]) System.out.println(i + " ");
        }
    }

    public  static void BFS(){
        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0, 0));
        visited[0][0] = true;
        answer[now[2]] = true;
        while(!queue.isEmpty()){
            AB tmp = queue.poll();
            int A = tmp.A;
            int B = tmp.B;
            int C = now[2] - A - B;
            for(int k = 0; k < 6; k++){
                int[] next = {A, B, C};
                next[receive[k]] += next[send[k]];
                next[send[k]] = 0;
                //물이 넘칠 때
                if(next[receive[k]] > now[receive[receive[k]]]){
                    next[send[k]] = next[receive[k]] - now[receive[k]];
                    next[receive[k]] = now[receive[k]];
                }
                if(!visited[next[0]][next[1]]){
                    visited[next[0]][next[1]] = true;
                    queue.add(new AB(next[0], next[1]));
                    if(next[0] == 0){
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }

    //A, B 값만 알면 C 값은 유추 가능
    static class AB{
        int A;
        int B;

        public AB(int A, int B){
            this.A = A;
            this.B = B;
        }
    }
}
