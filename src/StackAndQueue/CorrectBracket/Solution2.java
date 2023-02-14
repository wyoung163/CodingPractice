package StackAndQueue.CorrectBracket;

import java.util.*;

/*
    stack 사용
    추가하는 법 + "삭제"하는 법 함께 고려하기
 */
class Solution2 {
    boolean solution(String s) {
        boolean answer = false;
        Stack<Character> stack = new Stack<Character>();
        int length = s.length(), i = 0;

        while(i < length){
            if(s.charAt(i) == '(') {
                stack.push('(');
            } else{
                if(stack.isEmpty()){
                    return false;
                } else {
                    stack.pop();
                }
            }
            i++;
        }

        if(stack.isEmpty())
            answer = true;

        return answer;
    }
}