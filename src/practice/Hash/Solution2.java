package practice.Hash;

import java.util.*;

class Solution2 {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for(int i = 0; i < clothes.length; i++){
            if(map.containsKey(clothes[i][1])){
                map.put(clothes[i][1], map.get(clothes[i][1])+1);
            } else {
                map.put(clothes[i][1], 1);
                set.add(clothes[i][1]);
            }
        }

        int sum = 1;
        Iterator iter = set.iterator();
        while(iter.hasNext()) {
            int tmp = map.get(iter.next());
            // +1은 입지 않는 경우의 수 추가
            sum *= (tmp + 1);
        }

        // -1은 아무것도 입지 않는 경우의 수를 생각
        answer = sum - 1;
        return answer;
    }
}