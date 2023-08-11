package practice.Heap;

import java.util.*;

/*
    pq(heap)
    정확성 83.9 / 83.9
    효율성 16.1 / 16.1
 */
class Scoville {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < scoville.length; i++){
            pq.add(scoville[i]);
        }

        while(pq.peek() < K){
            // 큐 사이즈가 1 이하일 때 고려 <<문제 조건 잘 읽기>>
            if (pq.size() == 1)
                return -1;
            int first = pq.poll();
            int second = pq.poll();
            pq.add(first + second*2);
            answer++;
        }

        return answer;
    }
}