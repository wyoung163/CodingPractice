package SummerWinterCoding.FineSquare;

public class Solution {
    public long solution(int w, int h){
        long answer = 1;

        int max = 0;
        int r = w;
        int c = h;
        while(c > 0){
            int tmp = c / r;
            c = r;
            r = tmp;
        }
        max = r;

        answer = (long)(w*h - (w + h - max));
        return answer;
    }
}
