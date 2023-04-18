package practice.LifeBoat;

import java.util.*;

//그리디
class Solution2 {
    public int solution(int[] people, int limit) {
        int answer = 0, i = 0;
        Arrays.sort(people);

        //최솟값과 최댓값의 합이 limit보다 작으면 합해서 answer++, 그렇지 않으면 그 최댓값에 대해서만 answer++;
        //이때 최솟값의 위치는 항상 최댓값보다 작거나 같아야
        for(int j = people.length -1; j >= i; j--){
            if(people[i] + people[j] <= limit){
                i++;
            }
            answer++;
        }

        return answer;
    }
}