package practice.BigNumber;

import java.util.*;

//무조건 작은 수부터 다 제거해버리면 "4177252841"(test case3)의 경우 1, 2 총 4개가 삭제되어 47~이 되지만 맨 마지막 1 대신 4가 제거 된다면 77~로 더 큰수가 만들어지는 예외 발생)
class Solution {
    public String solution(String number, int k) {
        String answer = "";

        for(int num = 1; num < 10; num++){
            int cnt = 0;
            Queue<Integer> q = new LinkedList<>();
            for(int i = 0; i < number.length(); i++){
                if(Integer.parseInt(String.valueOf(number.charAt(i))) == num){
                    cnt++;
                    q.add(i);
                }
            }

            if(cnt <= k){
                number = number.replace(String.valueOf(num), "");
                k -= cnt;
            } else if(cnt > k){
                while(k > 0){
                    int idx = q.poll();
                    String tmp1 = number.substring(0, idx);
                    String tmp2 = number.substring(idx+1, number.length());
                    number = tmp1 + tmp2;
                    k--;
                }
            }
            if(k <= 0) break;
        }


        return number;
    }
}