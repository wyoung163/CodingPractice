package DoIt.Trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    069 문자열 찾
    트라이: 문자열 검색 빠르게 실행할 수 있도록 설계한 트리 형태 자료구조
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        tNode root = new tNode();
        while(n > 0){
            String text = br.readLine();
            tNode now = root;
            for(int i = 0; i < text.length(); i++){
                char c = text.charAt(i);
                if(now.next[c-'a'] == null){
                    now.next[c-'a'] = new tNode();
                }
                now = now.next[c-'a'];
                if(i == text.length() -1)
                    now.isEnd = true;
            }
            n--;
        }
        int cnt = 0;
        while(m > 0){
            String text = br.readLine();
            tNode now = root;
            for(int i = 0; i < text.length(); i++){
                char c = text.charAt(i);
                if(now.next[c-'a'] == null){
                    break;
                }
                now = now.next[c-'a'];
                if(i == text.length()-1 && now.isEnd)
                    cnt++;
            }
            m--;
        }
        System.out.println(cnt);
    }
    static class tNode {
        tNode[] next = new tNode[26];
        boolean isEnd;
    }
}
