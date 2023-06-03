package DoIt.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

/*
    029 원하는 정수 찾기
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for(int i = 0; i < n; i++){
            num[i] = sc.nextInt();
        }
        Arrays.sort(num);
        int m = sc.nextInt();
        for(int i = 0; i < m; i++){
            boolean find = false;
            int target = sc.nextInt();
            int start = 0;
            int end = num.length;
            while(start <= end){
                int mid_idx = (start + end) / 2;
                int mid_value = num[mid_idx];
                if(mid_value > target){
                    end = mid_idx - 1;
                } else if(mid_value < target){
                    start = mid_idx + 1;
                } else {
                    find = true;
                    break;
                }
            }
            if(find){
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

    }
}
