package practice.DP;

/*
    lv3 DP
    DP 배열 이용
    모든 경우의 수에 대한 결과 값 예측해서 최선의 결과 뽑아내기
 */
class Solution {
    public int solution(int[][] triangle) {
        int answer = triangle[0][0];
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        for(int i = 1; i < triangle.length; i++){
            // 맨 왼쪽
            dp[i][0] = dp[i-1][0] + triangle[i][0];

            // 사이
            for(int j = 1; j <= i; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
            }

            // 맨 오른쪽
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
        }

        for(int i = 0; i < triangle.length; i++){
            answer = Math.max(answer, dp[triangle.length-1][i]);
        }

        return answer;
    }
}