package practice.Hash;
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < clothes.length; i++) {
            if (map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            } else {
                map.put(clothes[i][1], 1);
                set.add(clothes[i][1]);
            }
        }

        int sum = 1;
        Iterator iter = set.iterator();
        while (iter.hasNext()) {
            int tmp = map.get(iter.next());
            answer += tmp;
            if (map.size() > 1) {
                sum *= tmp;
            }
        }

        if (map.size() > 1) {
            answer += sum;
        }

        return answer;
    }
}