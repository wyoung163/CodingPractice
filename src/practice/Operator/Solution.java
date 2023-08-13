package practice.Operator;

class Solution {
    public String solution(int n) {
        String[] numbers = {"4", "1", "2"};
        String answer = "";

        int num = n;

        while(num > 0){
            int remainder = num % 3;

            if(num % 3 == 0){
                num--;
            }
            num /= 3;

            answer = numbers[remainder] + answer;
        }

        return answer;
    }
}