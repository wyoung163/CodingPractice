package DoIt.TwoPointer;

/*
    투 포인터
    문제 008번
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        long A[] = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            A[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(A);
        for(int k = 0; k < n; k++){
            long find = A[k];
            int i = 0;
            int j = n-1;
            while(i < j){
                if(A[i] + A[j] == find){
                    if(i != k && j != k){
                        result++;
                        break;
                    } else if(i == k){
                        i++;
                    } else if(j == k){
                        j--;
                    }
                } else if(A[i] + A[j] < find){
                    i++;
                } else{
                    j--;
                }
            }
        }
        System.out.println(result);
        br.close();
    }
}
