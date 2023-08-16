package practice.Greedy;

import java.util.*;

/*
    Greedy 조이스틱
 */
class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;

        for(int i = 0; i < name.length(); i++){
            answer +=  Math.min(name.charAt(i)-'A', 26 - (name.charAt(i)-'A'));

            int idx = i+1;
            while(idx < name.length() && name.charAt(idx) == 'A'){
                idx++;
            }

            // 순서대로 가는 것과 뒤로 돌아가는 것 중 이동수가 적은 것 선택
            // i*2에서 *2는 현재 온 인덱스로부터 다시 뒤로 돌아가야 하기 때문에
            move = Math.min(move, i * 2 + name.length() - idx);
            //처음부터 뒷부분을 먼저 입력하는 것이 더 빠른 경우
            move = Math.min(move, (name.length()-idx)*2 + i);
        }

        return answer + move;
    }
}