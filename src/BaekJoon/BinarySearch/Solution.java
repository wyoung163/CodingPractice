package BaekJoon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int n, m, max, min, answer;
    static int[] len;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        len = new int[n];
        max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            len[i] = Integer.parseInt(st.nextToken());
            if(max < len[i]){
                max = len[i];
            }
        }
        min = 0;
        binarySearch();
    }

    static void binarySearch(){
        while(min < max){
            int mid = (min+max)/2;
            long sum = 0;

            for(int l: len){
                if(l > mid){
                    sum += (l-mid);
                }
            }

            if(sum >= m){
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        System.out.println(min-1);
    }
}
