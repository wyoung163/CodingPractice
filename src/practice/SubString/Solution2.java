package practice.SubString;

/*
    문자열을 수의 형태로 바꿀 필요 없이
    compareTo()를 이용한 차이 값을 이용해, 문자열 그대로 비교하여
    런타임 에러 해결
 */
class Solution2 {
    public int solution(String t, String p) {
        int answer = 0, i = 0;
        int len = p.length();

        while(i + len <= t.length()){
            if(t.substring(i, i+len).compareTo(p) <= 0){
                answer++;
            }
            i++;
        }

        return answer;

    }
}