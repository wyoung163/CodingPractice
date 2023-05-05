package practice.DefenceGame;

import java.util.*;

//우선순위 큐, 정확성: 84.4
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int[] mujuk = new int[k];

        for(int i = 0; i < k; i++){
            pq.add(enemy[i]);
        }

        int cnt = 0;
        for(int i = k; i < enemy.length; i++){
            if(enemy[i] <= n && enemy[i] > pq.peek()){
                n -= pq.poll();
                pq.add(enemy[i]);
                cnt++;
            }
            else if(enemy[i] <= n && enemy[i] <= pq.peek()){
                n -= enemy[i];
                cnt++;
            } else if(enemy[i] > n) {
                break;
            }
        }

        answer = k + cnt;
        return answer;
    }
}