package MonthlyCodeChallenge2.Divisor;

class Solution {
    public static void main(String[] args) {
        int answer = solution(13, 17);
        System.out.println(answer);
    }

    public static int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++){
            if(countDivisor(i) % 2 == 0)
                answer += i;
            else
                answer -= i;
        }
        return answer;
    }

    public static int countDivisor(int num) {
        int count = 0;
        for(int i = 0; i < num; i++){
            if(num % (i+1) == 0)
                count += 1;
        }
        return count;
    }
}