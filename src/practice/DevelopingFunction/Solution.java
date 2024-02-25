package practice.DevelopingFunction;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] finish = new int[progresses.length];

        for(int i = 0; i < progresses.length; i++){
            int remain = 100 - progresses[i];
            int day = remain / speeds[i];
            if(remain % speeds[i] > 0){
                day += 1;
            }
            finish[i] = day;
        }

        ArrayList<Integer> tmp = new ArrayList<>();
        int compare = finish[0];
        int cnt = 1;
        for(int i = 1; i < finish.length; i++){
            if(compare >= finish[i]){
                cnt++;
            } else {
                tmp.add(cnt);
                compare = finish[i];
                cnt = 1;
            }
        }
        tmp.add(cnt);

        int[] answer = new int[tmp.size()];
        for(int i = 0; i < tmp.size(); i++){
            answer[i] = tmp.get(i);
        }

        return answer;
    }
}