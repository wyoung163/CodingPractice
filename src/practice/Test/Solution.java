package practice.Test;

import java.util.*;

//57% 정답률
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        int[] answer1 = {1, 2, 3, 4, 5};
        int[] answer2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] answer3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for(int i = 0; i < answers.length; i++){
            if(answers[i] == answer1[i % 5]){
                answer[0]++;
            }
            if(answers[i] == answer2[i % 8]){
                answer[1]++;
            }
            if(answers[i] == answer3[i % 10]){
                answer[2]++;
            }
        }

        int max = answer[0];
        ArrayList<Integer> idx = new ArrayList<>();
        idx.add(1);

        for(int i = 1; i < 3; i++){
            if(max < answer[i]){
                for(int l = 0; l < idx.size(); i++){
                    idx.remove(l);
                }
                max = answer[i];
                idx.add(i+1);
            } else if(max == answer[i]){
                idx.add(i+1);
            }
        }

        answer = new int[idx.size()];
        for (int i = 0 ; i < idx.size() ; i++) {
            answer[i] = idx.get(i).intValue();
        }

        Arrays.sort(answer);
        return answer;

    }
}