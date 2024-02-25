package DoIt.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
    Problem 011
    스택
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        for(int i = 0; i < n; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        int cnt = 1;
        for(int i : num){
            while(cnt <= i) {
                stack.add(cnt++);
                System.out.println('+');
            }

            if(stack.peek() == i){
                stack.pop();
                System.out.println('-');
            }
        }
    }
}
