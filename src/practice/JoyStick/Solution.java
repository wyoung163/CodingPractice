package practice.JoyStick;

import java.util.*;

//40.5 accuracy
class Solution {
    public int solution(String name) {
        int answer = 0, num = 0, rnd = 1;
        Map<Character, Integer> map = new HashMap();

        //위 아래로 이동 횟수
        for(char i = 'A'; i <= 'Z'; i++){
            map.put(i, num);
            if(num < 13 && rnd == 2){
                num--;
            }
            if(num == 13 && rnd == 1){
                rnd = 2;
                num--;
            } else if(num < 13 && rnd == 1) {
                num++;
            }
        }

        //이동 횟수 모두 더한 뒤 A 갯수만큼 카운트 철회
        int cnt = 0;
        for(int i = 0; i < name.length(); i++){
            answer += map.get(name.charAt(i));
            if(name.charAt(i) == 'A'){
                cnt++;
            }

        }

        //A로 시작하거나 끝나는 문자는 cnt 횟수 다시 올리기
        if(name.charAt(0) == 'A' || name.charAt(name.length()-1) == 'A'){
            cnt-=1;
        }

        // 양옆 이동 횟수까지 고려
        return answer + name.length() - 1 - cnt;
    }
}