package practice.Fibonacci_numbers;

class Solution {
    public static void main(String[] args) {
        solution(3);
    }

    public static int solution(int n) {
        int answer = 0;
        if(n >= 2)
            answer = Fibonacci_numbers(n) % 1234567;
        else
            answer = Fibonacci_numbers(n);
        return answer;
    }

    public static int Fibonacci_numbers(int num){
        int result = 0;
        if(num > 1)
            result = Fibonacci_numbers(num-1) + Fibonacci_numbers(num-2);
        else
            result = num;
        return result;
    }
}