package practice.Sorting;

import java.util.*;

// [정렬] k번째 수
class Solution2 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++){
            ArrayList<Integer> arr = new ArrayList<Integer>();
            int s = commands[i][0];
            int e = commands[i][1];
            int k = commands[i][2];
            for(int j = s-1; j < e; j++){
                arr.add(array[j]);
            }
            Collections.sort(arr);
            answer[i] = arr.get(k-1);
        }

        return answer;
    }
}