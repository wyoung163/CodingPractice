package KakaoInternship.PickingDolls;

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer> cnt = new ArrayList<>();
        for(int i = 0; i < moves.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[j][moves[i]-1] > 0){
                    cnt.add(board[j][moves[i]-1]);
                    board[j][moves[i]-1] = 0;
                    if(cnt.size() >= 2){
                        if(cnt.get(cnt.size()-1) == cnt.get(cnt.size()-2)){
                            answer += 2;
                            cnt.remove(cnt.size()-1);
                            cnt.remove(cnt.size()-1);
                        }
                    }
                    break;
                }
            }
        }
        return answer;
    }
}