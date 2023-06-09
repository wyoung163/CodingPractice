package practice.TwoPointer;

import java.util.*;

//투 포인터, 연속 부분 수열 합의 개수
class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> hs = new HashSet<>();
        int answer = 0, pt1 = 0, pt2 = pt1+1;
        for(int i = 0; i < elements.length; i++){
            hs.add(elements[i]);
        }

        while(pt1 < elements.length){
            int sum = elements[pt1];
            while(pt2 < elements.length){
                sum += elements[pt2];
                hs.add(sum);
                pt2++;
            }
            pt2 = 0;
            while(pt2 < pt1){
                sum += elements[pt2];
                hs.add(sum);
                pt2++;
            }

            pt1++;
            pt2 = pt1 + 1;
        }

        answer = hs.size();

        return answer;
    }

}