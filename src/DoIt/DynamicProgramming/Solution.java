package DoIt.DynamicProgramming;

import java.util.Scanner;
/*
    084 정수를 1로 만들기
    동적 계획법
 */
public class Solution {
    static int n;
    static int D[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        D = new int[n+1];
        D[1] = 0;
        for(int i = 2; i <= n; i++){
            D[i] = D[i-1] + 1;
            if(i % 2 == 0) D[i] = Math.min(D[i], D[i / 2] + 1);
            if(i % 3 == 0) D[i] = Math.min(D[i], D[i / 3] + 1);
        }
        System.out.println(D[2]);
    }
}
