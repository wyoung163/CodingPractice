package practice.CuttingLan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    <매개변수 탐색>
    1. 이진탐색 알고리즘의 응용
    2. 최대, 최소를 찾는 문제를 o x 결정 문제로 바꿔서 접근
    3. 원하는 조건을 만족하는 가장 알맞은 값 찾기
    4. 조건을 만족하느냐 아니냐에 따라 탐색 범위 좁히기(이진탐색과의 유사점)
    5. 시간복잡도: O(log n)

    <동작 과정>
    1. 데이터 정렬
    2. 이진탐색 기법처럼 범위 반으로 줄여가기
    3. 시작과 끝이 같을 때까지 진행

    <조건>
    1. 최소값을 구하는 경우, 최솟값이 x라면, x 이상의 값에 대해서는 모두 조건 만족
    2. 최댓값을 구하는 경우, 최댓값이 y라면, y 이상의 값에 대해서는 모두 조건 만족
 */
public class Main {
    private static long binary_search(long arr[], int N, long max){
        long half = 0;
        long min = 0;

        while(min <= max) {
            half = (max + min)/2;
            long count = 0;

            for (long num : arr) {
                count += num / half;
            }

            //원하는 랜선 갯수 보다 잘라진 랜선 수가 적을 경우
            if (count < N) {
                max = half - 1;
            } else {
                min = half + 1;
            }
        }
        return (max+min) / 2;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long result = 0;
        long max = 0;

        long[] arr = new long[k];
        for(int i = 0; i < k; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        result = binary_search(arr, N, max);
        System.out.println(result);
        br.close();
    }
}
