package practice.ParcelBox;

import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0, p = 0;

        for(int i = 1; i <= order.length; i++){
            if(i == order[p]){
                p++;
                answer++;
                //continue;
            }
            while(!stack.isEmpty()){
                if(stack.peek() == order[p]){
                    stack.pop();
                    p++;
                    answer++;
                } else{
                    break;
                }
            }
            stack.add(i);
        }

        return answer;
    }
}