package practice.Test;
import java.util.*;

class Solution2 {
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

        int max = Math.max(answer[0], Math.max(answer[1], answer[2]));
        List<Integer> answ = new ArrayList<Integer>();
        for(int i=0; i< 3; i++)
            if(max == answer[i]) answ.add(i+1);

        answer = new int[answ.size()];
        for (int i = 0 ; i < answ.size() ; i++) {
            answer[i] = answ.get(i).intValue();
        }

        Arrays.sort(answer);
        return answer;

    }
}