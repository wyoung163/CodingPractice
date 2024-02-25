package practice.DFS;

class Solution {
    int cnt = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return cnt;
    }

    private void dfs(int[] numbers, int depth, int target, int sum){
        if(depth == numbers.length) {
            if(target == sum) cnt++;
            return;
        }

        int plus = sum + numbers[depth];
        int minus = sum - numbers[depth];

        dfs(numbers, depth+1, target, plus);
        dfs(numbers, depth+1, target, minus);
    }
}