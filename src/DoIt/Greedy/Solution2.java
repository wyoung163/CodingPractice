package DoIt.Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
    035 그리디
    기준을 두개 고려해야 해서 어려운 문제
    Comparator 사용법 익히기
 */
public class Solution2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] A = new int[n][2];
        for(int i = 0; i < n; i++){
            A[i][0] = sc.nextInt();
            A[i][1] = sc.nextInt();
        }
        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1 == o2) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int cnt = 0, end = -1;
        for(int i = 0; i < n; i++){
            if(A[i][0] >= end){
                end = A[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
