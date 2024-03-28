package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    현재 와인을 먹을 수 있는 경우
    1. 전 와인을 먹고 현재 와인을 먹는다
    2. 전전 와인을 먹고 현재 와인을 먹는다
    둘 중 더 큰 값을 dp 배열에 저장하며 최대로 마실 수 있는 와인의 양 구하기

    > (n-3)까지의 최대 양 + (n-1)번 째 양 + 현재 양
    > (n-2)까지의 최대 양 + 현재 양
 */
public class Solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] max = new int[n];
        max[0] = arr[0];
        max[1] = arr[0] + arr[1];
        max[2] = Math.max(max[1], arr[0] + arr[2]);
        max[2] = Math.max(max[2], arr[1]+arr[2]);
        for(int i = 3; i < n; i++){
            max[i] = Math.max(max[i-3]+arr[i-1]+arr[i], max[i-2] + arr[i]);
            max[i] = Math.max(max[i-1], max[i]);
        }

        System.out.println(max[n-1]);
    }
}
