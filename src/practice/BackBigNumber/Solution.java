package practice.BackBigNumber;

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> s = new Stack<>();
        //Queue<Integer> q = new LinkedList<>();

        answer[numbers.length-1] = -1;
        s.add(numbers[numbers.length-1]);
        for(int i = numbers.length-2; i >= 0; i--){
            if(numbers[i] == 9){
                answer[i] = -1;
                continue;
            }
            while(!s.isEmpty()){
                if(s.peek() <= numbers[i]){
                    s.pop();
                } else {
                    answer[i] = s.pop();
                    s.add(answer[i]);
                    break;
                }
            }
            if(answer[i] == 0) {
                answer[i] = -1;
            }
            s.add(numbers[i]);
        }

        return answer;
    }
}