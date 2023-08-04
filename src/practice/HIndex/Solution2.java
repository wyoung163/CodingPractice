package practice.HIndex;
import java.util.*;

/*
    테스트 케이스만 통과
    정답률: 12.5
 */
class Solution2 {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = citations[citations.length-1];
        int fix = citations.length-1;
        int len = 1;
        while(len < answer){
            answer = citations[--fix];
            len++;
        }

        return answer;
    }
}