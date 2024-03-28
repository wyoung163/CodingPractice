package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 실버 3 1003번
public class Solution {
    static int zero, one;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            zero = 0;
            one = 0;
            fibonacci(k);
            System.out.println(zero + " " + one);
        }

    }

    static int fibonacci(int n) {
        if(n==0){
            zero += 1;
            return 0;
        } else if (n==1){
            one += 1;
            return 1;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}
