package DoIt.SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    072 최소값 구하기2
    세그먼트 트리
    원리 분명하게 이해하고 암기하면 좋을 것 같음
 */
public class Solution2 {
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 수의 개수
        int m = Integer.parseInt(st.nextToken()); //구간의 최솟값 구하는 횟수
        int height = 0;
        int length = n;
        while(length != 0){
            length /= 2;
            height++;
        }
        int size = (int)Math.pow(2, height+1);
        int leftNodeStartIdx = size / 2 - 1;
        //트리 초기화
        tree = new long[size + 1];
        for(int i = 0; i < tree.length; i++){
            tree[i] = Integer.MAX_VALUE;
        }
        for(int i = leftNodeStartIdx + 1; i <= leftNodeStartIdx + n; i++){
            tree[i] = Long.parseLong(br.readLine());
        }
        setTree(size - 1);
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            s = s + leftNodeStartIdx;
            e = e + leftNodeStartIdx;
            System.out.println(getMin(s, e));
        }
        br.close();
    }

    private static long getMin(int s, int e){
        long min = Long.MAX_VALUE;
        while(s <= e){
            if(s % 2 == 1) {
                min = Math.min(min, tree[s]);
                s++;
            }
            s /= 2;
            if(e % 2 == 0){
                min = Math.min(min, tree[e]);
            }
            e /= 2;
        }
        return min;
    }

    private static void setTree(int i){
        while(i != 1){
            if(tree[i/2] > tree[2])
                tree[i/2] = tree[2];
            i--;
        }
    }
}
