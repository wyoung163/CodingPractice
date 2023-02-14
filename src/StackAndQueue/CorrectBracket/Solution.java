package StackAndQueue.CorrectBracket;

import java.util.*;

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