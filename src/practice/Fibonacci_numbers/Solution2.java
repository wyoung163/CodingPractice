package practice.Fibonacci_numbers;

class Solution2 {
    public static void main(String[] args) {
        solution(7);
    }

    public static int solution(int n) {
        int answer = 0;
        answer = Fibonacci_numbers(n);
        return answer;
    }

    public static int Fibonacci_numbers(int num){
        int result = 0;
        int n1 = 1, n2 = 1;
        if(num > 2)
            for(int i = 3; i <= num; i++) {
                result = (n1 + n2) % 1234567;
                n1 = n2;
                n2 = result;
            }
        else
            result = num;
        return result;
    }
}

/*
    <해결>
    문제점1 : n > 2인 수로 주어지는데 처음에 이를 고려하지 못하고 solution에서 % 1234567를 시도하면서 n이 2 미만인 수에 대해서도
    이 조건이 적용되는 문제를 만남
    문제점2 : Solution의 시간 초과
 */