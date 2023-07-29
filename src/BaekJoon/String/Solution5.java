package BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
   5534 간판
   [1] baraxbara 의 경우 bar 를 만들 수 있는 방법이 2가지임을 고려하지 못하는 문제
   [2] name의 맨 첫 글자와 끝 글자 사이를 같은 간격으로 계속 조사
 */
public class Solution5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String name = br.readLine();
        String[] pre = new String[n];
        for(int i = 0; i < n; i++){
            pre[i] = br.readLine();
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){
            int len = pre[i].length();
            for(int j = 0; j < len; j++) {
                if (pre[i].charAt(j) == name.charAt(0)){
                    for(int k = len-1; k > j; k--){
                        if(pre[i].charAt(k) == name.charAt(name.length()-1)){
                            int gap = (k-j) / (name.length()-1);
                            while(cnt < name.length()){
                                if(pre[i].charAt(j+gap*cnt) == name.charAt(cnt)){
                                    cnt++;
                                    continue;
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
