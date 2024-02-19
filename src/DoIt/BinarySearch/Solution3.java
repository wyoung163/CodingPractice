package DoIt.BinarySearch;

import java.util.Map;
import java.util.Scanner;

/*
    031 배열에서 k번째 수 찾기
    이진탐색
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long start = 1, end = m;
        long ans = 0;
        while(start <= end){
            long middle = (start + end) / 2;
            long cnt = 0;
            for(int i = 0; i <= n; i++){
                cnt += Math.min(middle / i, n);
            }
            if(cnt < m){
                start = middle + 1;
            } else {
                ans = middle;
                end = middle - 1;
            }
        }
        System.out.println(ans);
    }
}
