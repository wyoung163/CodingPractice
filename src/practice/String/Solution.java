package practice.String;

/*
    문제 조건 잘 읽고 테스트 케이스 예측해보는데 도움을 받은 문제
    JadenCase 문자열
 */
class Solution {
    public String solution(String s) {
        String answer = "";
        int cnt = 0;
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == ' '){
                cnt++;
            } else {
                break;
            }
        }

        String[] words = s.split(" ");
        for(int i = 0; i < words.length; i++){
            String tmp = "";
            for(int j = 0; j < words[i].length(); j++){
                if(j == 0 && !Character.isDigit(words[i].charAt(j))){
                    tmp += String.valueOf(words[i].charAt(j)).toUpperCase();
                } else {
                    tmp+= String.valueOf(words[i].charAt(j)).toLowerCase();
                }
            }
            answer += tmp;
            if(i == words.length-1) { break; }
            answer += " ";
        }

        if(cnt > 0){
            while(cnt > 0){
                answer += " ";
                --cnt;
            }
        }
        return answer;
    }
}