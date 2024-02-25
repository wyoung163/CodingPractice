package KakaoInternship.MakeQueueSame;

import java.util.*;

/*
    <주의사항에 실제로 명시된 내용>
    주의: 언어에 따라 합 계산 과정 중 산술 오버플로우 발생 가능성이 있으므로 long type 고려가 필요합니다.
 */
class Solution2 {
    public int solution(int[] queue1, int[] queue2) {
        //long 타입이 아니면 실패 case 발생
        long total1 = 0;
        long total2 = 0;
        int add = 0;
        int count = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i = 0; i < queue1.length; i++){
            total1 += queue1[i];
            q1.add(queue1[i]);
            total2 += queue2[i];
            q2.add(queue2[i]);
        }

        if((total1 + total2) % 2 != 0) return -1;

        while (total1 != total2) {
            count++;

            if(total1 > total2){
                add = q1.poll();
                q2.add(add);
                total2 += add;
                total1 -= add;
            } else {
                add = q2.poll();
                q1.add(add);
                total1 += add;
                total2 -= add;
            }

            if(count >= queue1.length * 3) return -1;

        }

        return count;
    }
}