package practice.Heap;

import java.util.*;

/*
    우선순위큐를 활용한 최소 최대 힙
    이중 우선순위 큐
 */

class Solution {
    PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> min = new PriorityQueue<>();
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        for(String operation: operations){
            String[] ops = operation.split(" ");
            int num = Integer.parseInt(ops[1]);
            if(ops[0].equals("I")){
                max.add(num);
                min.add(num);
            } else {
                if(num == -1) max.remove(min.poll());
                else min.remove(max.poll());
            }
        }
        // for(int i = 0; i < operations.length; i++){
        //     char[] now = operations[i].toCharArray();
        //     if(now[0] == 'I'){
        //         max.add(now[1]-'0');
        //         min.add(now[1]-'0');
        //     }
        //     else if(now[0] == 'D'){
        //         if(now[1] == '1'){
        //             int tmp = max.poll();
        //             min.remove(tmp);
        //         } else {
        //             int tmp = min.poll();
        //             max.remove(tmp);
        //         }
        //     }
        // }

        answer[0] = max.isEmpty() ? 0 : max.peek();
        answer[1] = min.isEmpty() ? 0 : min.peek();

        return answer;
    }
}