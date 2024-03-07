package practice.BinarySearch;

import java.util.Arrays;

// 프로그래머스 입국심사
public class Solution2 {
    // 모든 사람이 심사를 받는 데 걸리는 시간의 최솟값을 찾아야 한다 >> 무엇을 답으로 해야 하는지 파악!!!
    // 따라서 right 값 = 모든 사람이 가장 오래 걸리는 심사대에서 심사를 받는 시간
    public long solution(int n, int[] times){
        long answer = 0;
        Arrays.sort(times);
        long left = 0;
        long right = times[times.length-1] * (long) n;

        while(left <= right) {
            long mid = (left + right) / 2;
            long complete = 0;
            for(int i = 0; i < times.length; i++){
                complete += mid / times[i];
            }
            if (complete < n){ //해당 시간에 모든 사람이 검사받을 수 없음
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid; // 모두 검사받았지만 더 최솟값이 있을 수 있음
            }
        }
        return answer;
    }
}
