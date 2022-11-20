package practice.MinimumValue;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 2};
        int[] arr2 = {5, 4, 4};
        System.out.println(solution(arr1, arr2));
    }

    public static int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        reverseSort(B);

        for(int i = 0; i < A.length; i++){
            answer += A[i]*B[i];
        }

        return answer;
    }

    public static void reverseSort(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }
}
