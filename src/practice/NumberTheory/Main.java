package practice.NumberTheory;

import java.util.Scanner;

/*
    빈출: 소수 구하기
    <소수 판별법 - 에라토스테네스의 체 원리>
    1. 구하고자 하는 소수의 범위만큼 1차원 배열 생성
    2. 2부터 시작, 현재 숫자가 지워지지 않을 때
    현재 선택된 숫자의 배수에 해당하는 수를 배열에서 끝까지 탐색하여 지우기
    이때 처음 선택된 수는 지우지 않음
    3. 배열 끝까지 2를 반복한 후 배열의 남은 수 출력
    시간복잡도: O(log n(log n))
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[] num = new int[n+1];
        for(int i = 2; i <= n; i++){
            num[i] = i;
        }
        for(int i = 2; i <= Math.sqrt(n); i++){
            //제곱근까지만 수행
            if(num[i] == 0)
                continue;
            for(int j = i + i; j <= n; j = j + i){
                num[j] = 0;
            }
        }
        for(int i = m; i <= n; i++){
            if(num[i] != 0){
                System.out.println(num[i]);
            }
        }
    }
}
