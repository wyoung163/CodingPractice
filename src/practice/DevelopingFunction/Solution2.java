package practice.DevelopingFunction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//배열에서 큐로 자료구조 변경
class Solution2 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int day = remain / speeds[i];
            if (remain % speeds[i] > 0) {
                day += 1;
            }
            queue.add(day);
        }

        ArrayList<Integer> tmp = new ArrayList<>();
        int compare = queue.poll();
        int cnt = 1;
        for (int i = 1; i < progresses.length; i++) {
            if (compare >= queue.peek()) {
                cnt++;
                queue.poll();
            } else {
                tmp.add(cnt);
                compare = queue.poll();
                cnt = 1;
            }
        }
        tmp.add(cnt);

        int[] answer = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            answer[i] = tmp.get(i);
        }

        return answer;
    }
}

