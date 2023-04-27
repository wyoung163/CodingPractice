package practice.CompleteSearch;

import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int[] size = {sizes[0][0], sizes[0][1]};
        Arrays.sort(size);

        for(int i = 1; i < sizes.length; i++){
            Arrays.sort(sizes[i]);
            if(sizes[i][1] > size[1]){
                size[1] = sizes[i][1];
            } if(sizes[i][0] > size[0]){
                size[0] = sizes[i][0];
            }
        }

        answer = size[0] * size[1];
        return answer;
    }
}
