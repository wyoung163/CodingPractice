package practice.Sorting;

import java.util.Arrays;

// [정렬] 가장 큰 수
class Solution {
    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];
        for(int i = 0; i < str.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        /**오름차순
         Arrays.sort(str, (o1, o2) -> (o1+o2).compareTo(o2+o1));
         for(int i = 0; i < str.length; i++){
         System.out.println(str[i]);
         }
         */
        //내림차순
        Arrays.sort(str, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        /**
         for(int i = 0; i < str.length; i++){
         System.out.println(str[i]);
         }
         */

        if(str[0].equals("0")){
            return "0";
        }
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < str.length; i++){
            answer.append(str[i]);
        }
        return answer.toString();
    }
}