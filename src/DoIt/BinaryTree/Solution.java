package DoIt.BinaryTree;

import java.util.Scanner;

/*
    070 트리 순회하기
    이진 트리(각 노드의 자식 노드(차수)의 개수가 2 이하로 구성돼 있는 트리)
    완전 이진 트리 형태 떠올리기
    <순차 표현 - [배열]>
    목표 노드: 루트 | 부모 | 왼쪽 자식 | 오른쪽 자식
    인덱스 연산: 1 | idx/2 | idx*2 | idx*2+1 (세그먼트 트리, LCA 알고리즘의 기본이 되는 연산)
    제약조건: | 현재 노드가 루트가 아닐 때 | idx*2 <= n | idx*2+1 <= n
 */
public class Solution {
    static int[][] tree;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        tree = new int[26][2];
        for(int i = 0; i < 7; i++){
            String[] temp = sc.nextLine().split(" ");
            int node = temp[0].charAt(0) - 'A';
            char left = temp[1].charAt(0);
            char right = temp[2].charAt(0);
            //자식 노드 없을 때 -1 저장
            if(left == '.'){
                tree[node][0] = -1;
            } else {
                tree[node][0] = left - 'A';
            }
            if(right == '.'){
                tree[node][1] = -1;
            } else {
                tree[node][1] = right - 'A';
            }
        }
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();
    }
    public static void preOrder(int n){
        if(n == -1){
            return;
        }
        System.out.println((char) (n + 'A')); //현재 노드
        preOrder(tree[n][0]); //왼쪽 탐색
        preOrder(tree[n][1]); //오른쪽 탐색
    }
    public static void inOrder(int n){
        if(n == -1)
            return;
        inOrder(tree[n][0]);
        System.out.println((char) (n + 'A'));
        inOrder(tree[n][1]);
    }
    public static void postOrder(int n){
        if(n == -1)
            return;
        postOrder(tree[n][0]);
        postOrder(tree[n][1]);
        System.out.println((char) (n+'A'));
    }
}
