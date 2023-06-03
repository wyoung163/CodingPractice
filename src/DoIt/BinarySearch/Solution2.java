package DoIt.BinarySearch;

import java.util.Scanner;

/*
    030 블루레이 만들기
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] num = new int[n];
        int start = 0;
        int end = 0;
        for(int i = 0; i < n; i++){
            num[i] = sc.nextInt();
            if(start < num[i]) start = num[i]; //레슨의 최댓값을 시작 인덱스로 저장
            end = end + num[i]; //모든 레슨의 총합을 종료 인덱스로 설정
        }
        while (start <= end){
            int mid = (start + end) / 2;
            int sum = 0;
            int cnt = 0;
            for(int i = 0; i < n; i++){ //mid 값으로 모든 레슨 저장할 수 있는지 확인
                if(sum + num[i] > mid){
                    cnt++;
                    sum = 0;
                }
                sum = sum + num[i];
            }
            //반복문 마쳤는데 sum이 0이 아니라면 마지막 블루레이가 필요
            if(sum != 0){
                cnt++;
            }
            if(cnt > m)
                start = mid + 1;
            else
                end = mid - 1;
            //System.out.println(cnt);
        }
        System.out.println(start);
    }
}
