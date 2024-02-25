package practice.ExhaustiveSearch;

/*
    완전탐색 문제
    공통적으로 적용되는 수식 찾기
    반복문의 조건을 하나씩 바꾸며 모든 경우의 수 살펴보기
    인자로 넘어온 값 적극 활용하기
 */
public class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown / 2;

        for (int r = total - 1; r >= total / 2; r--) {
            int c = total - r;
            if ((c - 1) * (r - 1) == yellow) {
                if (c < r) {
                    answer[1] = c + 1;
                    answer[0] = r + 1;
                } else {
                    answer[0] = c + 1;
                    answer[1] = r + 1;
                }
            }
        }

        return answer;
    }
}

