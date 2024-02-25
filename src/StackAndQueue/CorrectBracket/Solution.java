package StackAndQueue.CorrectBracket;

import java.util.*;
/*
    <큐> 이용
    굳이 다 넣고 하나씩 빼면서 확인할 필요 없을 것 같음
    너무 비효율적
    오류 2 케이스 발생
 */
class Solution {
    boolean solution(String s) {
        boolean answer = false;
        int i = 0, left = 0, right = 0;
        Queue<String> queue = new LinkedList<>();
        int length = s.length();

        while(i < length){
            if(i == 0){
                if((s.substring(i, i+1)).equals(")") == true){
                    return false;
                }
            }
            queue.add(s.substring(i, i+1));
            i++;
        }

        i = 0;
        int size = queue.size();
        while(i < size){
            if(queue.poll().equals("(")){
                left++;
            } else{
                right++;
            }
            i++;
        }

        if(left == right)
            answer = true;

        return answer;
    }
}