package practice.SplittingString;

class Solution {
    public int solution(String s) {
        int answer = 1, i = 1, c = 1, r = 0;
        String x = s.substring(0, 1);

        while(i < s.length()-1){
            if((s.substring(i, i+1)).equals(x)){
                c++;
            } else {
                r++;
            }

            if(c == r){
                answer++;
                i++;
                x = s.substring(i, i+1);
                c = 1;
                r = 0;
            }
            i++;
        }

        return answer;
    }
}