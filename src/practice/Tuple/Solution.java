package practice.Tuple;

import java.util.*;

/*
    lv2 튜플
    문자열 substring, split(결과물이 배열),
    Arrays.sort(배열, new Comparator<>() {
        public int compare( o1, o2) {
            return Integer.compare(o1, o2);
        }
    }
 */
class Solution {
    public ArrayList<Integer> solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();
        // 가장 앞의 {{ 제거
        s = s.substring(2, s.length());
        // 가장 뒤의 }} 제거한 후 },{ 형태를 -로 변경
        s = s.substring(0, s.length()-2).replace("},{", "-");
        String str[] = s.split("-");
        Arrays.sort(str, new Comparator<String>(){
            public int compare(String o1, String o2){
                return Integer.compare(o1.length(), o2.length());
            }
        });

        for(String x: str){
            String[] temp = x.split(",");
            for(int i = 0; i < temp.length; i++){
                int n = Integer.parseInt(temp[i]);
                if(!answer.contains(n))
                    answer.add(n);
            }
        }
        return answer;
    }
}