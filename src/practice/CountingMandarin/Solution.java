package practice.CountingMandarin;

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0, result = 0;
        int[] count = new int[10000000];
        // count = new Integer[1000];

        for(int i = 0; i < tangerine.length; i++){
            count[tangerine[i]] += 1;
        }

        Arrays.sort(count);

        for(int i = count.length-1; i >= 0; i--){
            while(count[i] != 0 && (result + count[i]) < k){
                result = result + count[i];
                answer += 1;
            }
        }

        return answer;
    }
}