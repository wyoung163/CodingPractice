package practice.CountingMandarin;

import java.util.*;

/*
 * 투 포인터 사용
 * 정확도 합계: 67.6 / 100.0
 */
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0, result = 0;
        int[] count = new int[10000000];
        // count = new Integer[1000];
        int s_index = 9999999, e_index = 9999999;

        for(int i = 0; i < tangerine.length; i++){
            count[tangerine[i]] += 1;
        }

        //내림차순
        Arrays.sort(count);

        //셈의 합이 k가 아니고 인덱스 범위가 올바를 때
        while(result != k && s_index > 0 && e_index > 0){
            //지금까지의 합과 새 셈을 더했을 때 k와 같거나 넘지 않으면
            if(result + count[e_index] <= k){
                //셈 더해주기
                result = result + count[e_index];
                //귤 종류 하나 추가
                answer += 1;
                //다음 셈을 위한 인덱스
                e_index--;
            } else{ //k보다 결과가 커진다면 <-- 여기가 문제다!!!
                result = k;
                answer = 1;
            }

            //셈할 숫자가 0이라면
            if(count[e_index] == 0){
                //초기화
                result = 0;
                //초기화
                answer = 0;
                //시작 인덱스 앞으로 옮기기
                s_index--;
                //시작할 인덱스 물려받기
                e_index = s_index;
            }
        }

        return answer;
    }
}