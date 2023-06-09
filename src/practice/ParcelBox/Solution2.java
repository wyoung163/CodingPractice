package practice.ParcelBox;

import java.util.*;

class Solution2 {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0, p = 0;
        boolean peek = false; //stack에 임시 보관할 필요 없는, 이미 선택된 수를 의미

        for (int i = 1; i <= order.length; i++) {
            peek = false;

            if (i == order[p]) {
                p++;
                answer++;
                peek = true;
            }
            if (!stack.isEmpty()) {
                while (!stack.isEmpty()) {
                    if (stack.peek() == order[p]) {
                        stack.pop();
                        p++;
                        answer++;
                        peek = true;
                        continue;
                    } else {
                        break;
                    }
                }
            }
            if (peek == false) {
                stack.add(i);
            }

        }

        return answer;
    }
}