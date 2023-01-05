package practice;

public class NumberRepresentation {
    public int solution(int n) {
        int answer = 0, j = 0, count = 0;

        for (int i = 1; i <= n; i++) {
            j = i;
            while (answer < n && j <= n) {
                answer += j++;
            }
            if (answer == n)
                count++;
            answer = 0;
        }
        return count;
    }
}
