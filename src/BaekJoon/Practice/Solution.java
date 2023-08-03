package BaekJoon.Practice;

import java.util.HashMap;
import java.util.Map;

/*
    lv2 할인행사
 */
public class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0, total = 10;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            map.put(want[i], number[i]);
        }

        for(int i = 0; i < discount.length - total; i++){
            Map<String, Integer> temp = new HashMap<>();
            for(int j = i; j < i+total; j++){
                temp.put(discount[j], temp.getOrDefault(discount[j], 0)+1);
            }
            /*
                getOrDefault(key, defaultValue)
                key: element key whose value has to be obtained
                defaultValue: has to be returned if no value is mapped with specific key
             */
            Boolean isIdentical = true;

            for(String key : map.keySet()){
                if(map.get(key) != temp.get(key)){
                    isIdentical = false;
                    break;
                }
            }
            answer += isIdentical ? 1:0;
        }
        return answer;
    }
}
