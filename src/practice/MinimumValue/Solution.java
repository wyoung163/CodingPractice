package practice.MinimumValue;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 2};
        int[] arr2 = {5, 4, 4};
        System.out.println(solution(arr1, arr2));
    }

    public static int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Integer[] B2 = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(B2, Collections.reverseOrder());

        for(int i = 0; i < A.length; i++){
            answer += A[i]*B2[i];
        }

        return answer;
    }
}
