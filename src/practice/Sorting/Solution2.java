package practice.Sorting;

import java.util.*;

/**
 * [정렬] 테이블 해시 함수
 */
class Solution2 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        //Arrays.sort(data, (o1, o2) -> (String.valueOf(o1[col-1])).compareTo(String.valueOf(o2[col-1])));

        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[col-1] - o2[col-1] == 0){
                    return o2[0] - o1[0];
                } else return o1[col-1] - o2[col-1];
            }
        });

        int[] arr = new int[row_end];
        int s = 0;
        for(int i = row_begin-1; i < row_end; i++){
            s = 0;
            for(int j = 0; j < data[0].length; j++){
                s += data[i][j] % (i+1);
            }
            arr[i] = s;
        }

        s = arr[row_begin-1];
        for(int i = row_begin; i < row_end; i++){
            s = s ^ arr[i];
        }
        return answer = s;
    }
}