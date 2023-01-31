package practice.CountingMandarin;

import java.util.*;

/*
 * 투 포인터 사용
 * 정확성: 79.4
 * 합계: 79.4 / 100.0
 */
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0, result = 0;
        int[] count = new int[10000000];
        int s_index = 9999999, e_index = 9999999;

        for(int i = 0; i < tangerine.length; i++){
            count[tangerine[i]] += 1;
        }

        Arrays.sort(count);

        while(result != k){
            if(result + count[e_index] <= k){
                result = result + count[e_index];
                answer += 1;
            }
            e_index--;

            if(count[e_index] == 0){
                result = 0;
                answer = 0;
                s_index--;
                e_index = s_index;

                //합산 결과가 k로 나누어 떨어지지 않을 때 경우의 수가 무조건 1이 되는 것이 아니라 맨 처음 셈이 k보다 작으면 모자란 만큼 다음 인덱스의 셈에서 값 충당 필요
                //그러면 경우의 수는 1보다 커짐
                if(count[s_index] == 0){
                    int index = 9999999;
                    while(result < k){
                        if(count[index] > k){
                            answer += 1;
                            result = k;
                        } else{
                            result = result + count[index];
                            answer += 1;
                        }
                        index--;
                    }
                    result = k;
                }
            }
        }

        return answer;
    }
}