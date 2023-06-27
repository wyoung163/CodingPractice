package DoIt.Tree;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static int[] parent;
    static ArrayList<Integer>[] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        arr = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i = 0; i < n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }
        DFS(1);
        for(int i = 2; i <= n; i++){
            System.out.println(parent[i]);
        }
    }
    static void DFS(int i){
        for(int n: arr[i]){
            if(parent[n] != 0)
                continue;
            else {
                parent[n] = i;
                DFS(n);
            }
        }
    }
}
