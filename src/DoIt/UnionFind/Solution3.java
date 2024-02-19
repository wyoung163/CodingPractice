package DoIt.UnionFind;

import java.util.ArrayList;
import java.util.Scanner;

/*
    052 거짓말쟁이가 되신 싫어
    유니온-파인드
 */
public class Solution3 {
    static int[] truth; //진실을 알고 있는 사람 번호
    static ArrayList<Integer>[] party; //각 파티에 오는 사람 번호 저장
    static int[] parent;
    static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //사람 수
        int m = sc.nextInt(); //파티 수
        int k = sc.nextInt(); //진실을 아는 사람 수
        truth = new int[k];
        for(int i = 0; i < k; i++){
            truth[i] = sc.nextInt();
        }
        party = new ArrayList[m+1];
        for(int i = 1; i <= m; i++){
            int j = sc.nextInt();
            party[i] = new ArrayList<>();
            for(int l = 0; l < j; l++){
                party[i].add(sc.nextInt());
            }
        }
        parent = new int[n+1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
        for(int i = 1; i <= m; i++){ // 각 파티에 참여한 사람들을 1개의 그룹으로
            int firstPerson = party[i].get(0);
            for(int j = 1; j < party[i].size(); j++){
                union(firstPerson, party[i].get(j));
            }
        }
        //각 파티 대표 노드와 진실 아는 사람들의 대포 노도 같다면 과장 불가능
        for(int i = 1; i <= m; i++){
            boolean isPossible = true;
            int cur = party[i].get(0);
            for(int j = 0; j < truth.length; j++){
                if(find(cur) == find(truth[j])){
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) result++;
        }
        System.out.println(result);
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;
        }
    }
    public static int find(int a){
        if(a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);
    }

}

