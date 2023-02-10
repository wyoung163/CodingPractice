package practice.HotelRoom;

import java.util.*;

/*
    우선순위큐
 */

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        PriorityQueue<Integer> input = new PriorityQueue<Integer>();
        PriorityQueue<Integer> output = new PriorityQueue<Integer>();

        for(int i = 0; i < book_time.length; i++) {
            input.add(calc_time(book_time[i][0]));
            output.add(calc_time(book_time[i][0] + 10) + 10);
        }

        return answer;
    }

    //HH:MM 형태의 문자열 시간을 min 기준의 수로 변경
    public int calc_time(String time){
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);

    }
}