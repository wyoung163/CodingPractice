package practice.LifeBoat;

import java.util.*;

//완벽한 오류 코드 max 값부터 차례대로 접근한 방식
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int tmp = 0, cnt = 0, i = 0;
        Arrays.sort(people);

        // #시도2
        if (people[i] > limit - 40) {
            answer++;
        } else {
            if (tmp > 0) {
                if (people[i] + tmp <= limit) {
                    answer++;
                    tmp = 0;
                }
            } else {
                tmp = people[i];
            }
        }


        // #시도1
         if(tmp + people[i] <= limit - 40 && tmp == 0){
             ++cnt;
             tmp = people[i];
         } else if(tmp + people[i] <= limit && cnt == 1) {
             cnt = 0;
             answer++;
             tmp = 0;
         }
         else {
             answer++;
             tmp = 0;
         }

         if(i == 0 && tmp > 0){
             answer++;
         }

        return answer;
    }
}
