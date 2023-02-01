package practice.CuttingRollcake;

import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0, i = 0;
        int division = topping.length / 2;
        HashSet<Integer> hs_l = new HashSet<Integer>();
        HashSet<Integer> hs_r = new HashSet<Integer>();
        int c = 0;

        while(division > 1 && division < topping.length){
            i = 0;
            while(i < division){
                hs_l.add(topping[i]);
                i++;
            }

            i = division;
            while(i < topping.length){
                hs_r.add(topping[i]);
                i++;
            }

            if(hs_l.size() < hs_r.size() && c <= 0){
                c = -1;
                division++;
            } else if (hs_l.size() > hs_r.size() && c >= 0) {
                c = 1;
                division--;
            } else if (hs_l.size() == hs_r.size()) {
                answer++;
                c = -1;
                division++;
            } else {
                division = 0;
            }

            hs_l.clear();
            hs_r.clear();
        }

        return answer;

    }
}