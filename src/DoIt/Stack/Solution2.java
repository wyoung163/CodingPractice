package DoIt.Stack;

import java.io.*;
import java.nio.Buffer;
import java.util.Stack;

/*
    Problem012
    스택
 */
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] ans = new int[n];
        String[] str = br.readLine().split(" ");

        for(int i = 0; i < n; i++){
            A[i] = Integer.parseInt(str[i]);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i = 1; i < n; i++){
            while(!stack.isEmpty() && A[stack.peek()] < A[i]){
                ans[stack.pop()] = A[i];
            }
            stack.push(i);
        }
        while(!stack.empty()){
            //반복문 다 돌았는데도 스택이 비지 않다면 빌 떄까지
            ans[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < n; i++){
            bw.write(ans[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
