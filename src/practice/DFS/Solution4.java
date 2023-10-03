package practice.DFS;

/*
    lv2 프로그래머스 피로도
    완전탐색(dfs)
    for문의 위치가 main에 위치해야 할지, dfs 함수 내에 위치해야 할지를 고민하기 
 */
class Solution4 {
    public boolean visited[];
    public int answer = 0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return answer;
    }
    public void dfs(int d, int k, int[][] dungeons){
        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i] && dungeons[i][0] <= k){
                visited[i] = true;
                dfs(d+1, k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, d);
    }
}