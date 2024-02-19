package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5 {
    static int n;
    static int[] numbers;
    static int[] operators; // +, -, x, %
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int val;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        operators = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            operators[i] = Integer.parseInt(st.nextToken());
        }

        val = numbers[0];
        back(1);
        System.out.println(max);
        System.out.println(min);
    }

    static void back(int depth){
        if(depth == n) {
            min = Math.min(val, min);
            max = Math.max(val, max);
            return;
        }
        for(int i = 0; i < 4; i++){
            if(operators[i] == 0) continue;
            calculate(i, depth);
            operators[i] -= 1;
            back(depth+1);
            rewind(i, depth);
            operators[i] += 1;
        }
    }

    static void calculate(int operator, int depth){
        switch (operator){
            case 0: val += numbers[depth]; break;
            case 1: val -= numbers[depth]; break;
            case 2: val *= numbers[depth]; break;
            case 3: val /= numbers[depth]; break;
        }
    }

    static void rewind(int operator, int depth){
        switch (operator){
            case 0: val -= numbers[depth]; break;
            case 1: val += numbers[depth]; break;
            case 2: val /= numbers[depth]; break;
            case 3: val *= numbers[depth]; break;
        }
    }
}
