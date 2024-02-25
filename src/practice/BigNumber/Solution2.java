package practice.BigNumber;

import java.util.*;

class Solution2 {
    public String solution(String number, int k) {
        String answer = "";

        //k 이하를 없애서 맨 앞에 가장 큰 수가 올 수 있도록
        for(int num = 9; num > 5; num--){
            Queue<Integer> q = new LinkedList<>();
            for(int i = 0; i < number.length(); i++){
                if(Integer.parseInt(String.valueOf(number.charAt(i))) == num){
                    q.add(i);
                }
            }

            if(q.size() > 0){
                int idx = q.poll();
                if(idx < k){
                    number = number.substring(idx, number.length());
                    k -= idx;
                    break;
                }
            }
        }

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