package practice.SubString;

/*
    런타임에러 발생
 */

class Solution {
    public int solution(String t, String p) {
        int answer = 0, i = 0;
        int len = p.length();

        while(i + len <= t.length()){
            //System.out.println(Integer.parseInt(t.substring(i, i+len)));
            if(Integer.parseInt(t.substring(i, i+len)) <= Integer.parseInt(p)){
                answer++;
            };
            i++;
        }
        return answer;

    }
}