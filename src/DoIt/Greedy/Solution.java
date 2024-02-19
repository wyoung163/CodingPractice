package DoIt.Greedy;


import java.util.PriorityQueue;
import java.util.Scanner;

/*
    033 카드 정렬하기
    그리디 기본 문제
    우선순위 큐
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 오름차순 정렬
        for(int i = 0; i < n; i++){
            int data = sc.nextInt();
            pq.add(data);
        }
        int data1 = 0, data2 = 0, sum = 0;
        while(pq.size() != 1){
            data1 = pq.remove();
            data2 = pq.remove();
            sum += data1 + data2;
            pq.add(data1 + data2);
        }
        System.out.println(sum);

    }
}
