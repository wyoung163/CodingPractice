package practice.CountingMandarin;

import java.util.*;

class Solution2 {
    public int solution(int k, int[] tangerine) {
        int answer = 0, sum = 0, num = 0, min = 9999, pt = 0;
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

        Loop1 :
        for(int i = 0; i < key.length; i++){
            sum = 0;
            answer = 0;
            pt = i;
            while(pt < key.length){
                if(cnt.get(key[pt]) > k){
                    min = 1;
                    break Loop1;
                }

                if(cnt.get(key[pt]) + sum <= k){
                    sum += cnt.get(key[pt]);
                    answer++;
                }
                pt++;

                if(sum == k){
                    min = Math.min(min, answer);
                    pt = key.length;
                }
            }
        }

        return min;
    }
}