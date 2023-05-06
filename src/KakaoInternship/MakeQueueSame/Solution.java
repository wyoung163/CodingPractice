package KakaoInternship.MakeQueueSame;

import java.util.Arrays;

class Solution {
    public int num = 0;

    public int pop(int[] q){
        num = q[0];
        for(int i = 0; i < q.length - 1; i++){
            q[i] = q[i+1];
        }
        q[q.length - 1] = 0;
        return num;
    }

    public int[] insert(int[] q, int n){
        int[] newArray = Arrays.copyOf(q, q.length + 1);
        newArray[q.length] = n;
        return newArray;
    }

    public int getSum(int[] q){
        int sum = 0;
        for(int i = 0; i < q.length; i++){
            sum += q[i];
        }
        return sum;
    }

    public int solution(int[] queue1, int[] queue2) {
        int total = 0;
        int add = 0;
        int count = 0;
        int length = queue1.length;

        for(int i = 0; i < queue1.length; i++){
            total += queue1[i];
            total += queue2[i];
        }

        while (getSum(queue1) != total / 2 && getSum(queue2) != total / 2) {
            if(getSum(queue2) > (total / 2)){
                add = pop(queue2);
                queue1 = insert(queue1, add);
                count++;
            } else if(getSum(queue1) > (total / 2)) {
                add = pop(queue1);
                queue2 = insert(queue2, add);
                count++;
            }
            if(count >= length * 2) return -1;
        }

        return count;
    }
}