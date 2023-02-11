package practice.CountingMandarin;

import java.util.*;
/*
    최종
 */

class Solution4 {
    public int solution(int k, int[] tangerine) {
        int answer = 0, sum = 0, num = 0;
        HashMap<Integer, Integer> cnt = new HashMap<Integer, Integer>();

        for(int i = 0; i < tangerine.length; i++){
            if(cnt.get(tangerine[i]) != null)
                cnt.put(tangerine[i], (cnt.get(tangerine[i])+1));
            else
                cnt.put(tangerine[i], 1);
        }


        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<Map.Entry<Integer, Integer>>(cnt.entrySet());

        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>()  {
            public int compare(Map.Entry<Integer, Integer> obj1, Map.Entry<Integer, Integer> obj2){
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });

        Integer[] key = new Integer[cnt.size()];
        for(Map.Entry<Integer, Integer> entry : entryList){
            key[num++] = entry.getKey();
        }

        //이 부분이 핵심! 잘 이해하기
        num = 0;
        while(k > 0){
            answer++;
            k -= cnt.get(key[num]);
            num++;
        }

        return answer;
    }
}