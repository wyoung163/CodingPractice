package practice.HIndex;

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int start = 0;
        int end = citations.length;

        while (start < end) {
            int mid = (start + end) / 2;
            if (citations.length - mid - 1 == citations[mid]) {
                answer = citations.length - mid - 1;
                break;
            } else if (citations.length - mid - 1 > citations[mid]) {
                answer = citations.length - mid - 1;
                start += 1;
            } else {
                end -= 1;
            }
        }
        return answer;
    }
}
