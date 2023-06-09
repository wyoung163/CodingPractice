package DoIt.TopologicalSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Solution054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            A.add(new ArrayList<>());
        }
        int[] indegree = new int[n+1];
        int[] selfBuild = new int[n+1];
        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            selfBuild[i] = Integer.parseInt(st.nextToken());
            while(true){
                int pre = Integer.parseInt(st.nextToken());
                if(pre == -1){
                    break;
                } else {
                    A.get(pre).add(i);
                    indegree[i]++;
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        int[] result = new int[n+1];
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int next : A.get(now)){
                indegree[next]--;
                result[next] = Math.max(result[next], result[now] + selfBuild[now]);
                if(indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }
        for(int i = 1; i <= n; i++){
            System.out.println(result[i] + selfBuild[i]);
        }
    }
}
