package practice.ExercisingClothes;

import java.util.ArrayList;

//정답률 76
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        ArrayList<Integer> reserveList = new ArrayList<>(reserve.length);

        for (int i : reserve) {
            reserveList.add(i);
        }

        for(int i = 0; i < lost.length; i++){
            if(reserveList.contains(lost[i])){
                answer++;
                reserveList.remove(reserveList.indexOf(lost[i]));
            } else if(reserveList.contains(lost[i] + 1)){
                answer++;
                reserveList.remove(reserveList.indexOf(lost[i] + 1));
            } else if (reserveList.contains(lost[i]-1)) {
                answer++;
                reserveList.remove(reserveList.indexOf(lost[i] - 1));
            }
        }


        return answer;
    }
}
