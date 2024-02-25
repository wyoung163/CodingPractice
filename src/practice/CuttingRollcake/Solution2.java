package practice.CuttingRollcake;

import java.util.*;

/*
    참고 출처: https://choiyb2.tistory.com/122
 */
class Solution2 {
    public int solution(int[] topping) {
        int length = topping.length;

        HashSet<Integer> hs = new HashSet<>();
        /*
            동생이 가질 토핑은 HashMap 형태로 저장하기
            key로 토핑 종류를, value로 해당 토핑의 개수를 저장한 뒤,
            하나씩 나에게 넘겨주면서(그럼 동생의 value 값은 하나씩 줄어듦)
            나와 동생이 가진 토핑 종류의 개수가 같아질 떄의 경우의 수를 찾는다.
         */
        HashMap<Integer, Integer> hm = new HashMap<>();

        hs.add(topping[0]);
        for (int i = 1; i < length; i++) {
            int type = topping[i];
            hm.put(type, hm.getOrDefault(type, 0) + 1);
        }

        int answer = 0;
        for (int i = 1; i < length; i++) {
            int type = topping[i];

            hs.add(type);

            int typeCount = hm.get(type);
            if (typeCount == 1) {
                hm.remove(type);
            } else {
                hm.put(type, typeCount - 1);
            }

            if (hs.size() == hm.size()) {
                answer++;
            }
        }

        return answer;
    }
}