package DoIt.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.PriorityQueue;

/*
    014
    우선순위 큐
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int first = Math.abs(o1);
            int second = Math.abs(o2);
            if(first == second)
                return o1 > o2 ? 1 : -1; //절댓값 같으면 음수 우선
            else return first - second; //절댓값 기준
        });

        for(int i = 0; i < n; i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp != 0){
                pq.add(tmp);
            } else {
                if(!pq.isEmpty()) {
                    System.out.println(pq.poll());
                } else {
                    System.out.println('0');
                }
            }
        }
    }
}
