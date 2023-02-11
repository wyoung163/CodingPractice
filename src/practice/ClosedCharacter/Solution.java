package practice.ClosedCharacter;

import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<String, Integer> pos = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            if(pos.get(s.substring(i, i+1)) != null){
                answer[i] = i - pos.get(s.substring(i, i+1));
            }
            else{
                answer[i] = -1;
            }
            pos.put(s.substring(i, i+1), i);
        }

        return answer;
    }
}
