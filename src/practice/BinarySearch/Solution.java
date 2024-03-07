package practice.BinarySearch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        int[][] nodeinfo = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
        int[][] answer = solution(nodeinfo);

        for (int i = 0; i < answer.length; i++) {
            System.out.println(Arrays.toString(answer[i]));
        }
    }

    public static class Data {
        int num; //nodeinfo 배열에서 몇번 째인지 index 값
        int x; // x 좌표
        int y; // y 좌표

        public Data(int num, int x, int y){
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    public static class Node {
        private Data data; //실질적인 데이터가 들어가는 필드
        private Node left; //노드의 왼쪽 서브 트리
        private Node right; //노드의 오른쪽 서브 트리

        public Node(Data data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /*
        트리를 생성할 때, 트리가 null일 때 가장 처음으로 삽입되는 노드가 트리의 root가 된다.
        따라서 트리 생성할 떄 y 값이 가장 큰 좌표값부터 삽입해야 한다
     */

    public static Node root = null;
    public static List<Integer> preOrderList = new ArrayList<>();
    public static List<Integer> postOrderList = new ArrayList<>();

    public static int[][] solution(int[][] nodeInfo) {
        List<Data> dataList = new ArrayList<>();
        for(int i = 0; i < nodeInfo.length; i++){
            Data data = new Data(i+1, nodeInfo[i][0], nodeInfo[i][1]);
            dataList.add(data);
        }

        Arrays.sort(nodeInfo, (o1, o2) -> {
            int result = Integer.compare(o1[1], o2[1]);
            if (result == 0){
                return Integer.compare(o1[0], o2[0]);
            } else {
                return -result;
            }
        });

        Collections.sort(dataList, ((o1, o2) -> {
            if(o1.y == o2.y){
                return o1.x - o2.x;
            }
            return o2.y - o1.y;
        }));

        for(Data data: dataList){
            insertNode(data);
        }

//        preOrder(root);
//        postOrder(root);

        int[][] answer = new int[2][postOrderList.size()];
        for(int i = 0; i < preOrderList.size(); i++){
            answer[0][i] = preOrderList.get(i);
            answer[1][i] = postOrderList.get(i);
        }
        return answer;
    }

    public static void insertNode(Data data){
        Node newNode = new Node(data);

        if(root == null){
            root = newNode;
            return;
        }
        Node currentNode = root;
        Node parentNode;

        while(true){
            parentNode = currentNode;

            if(data.x < currentNode.data.x) {
                currentNode = currentNode.left;

                if(currentNode == null){
                    parentNode.left = newNode;
                    return;
                }
            } else {
                currentNode = currentNode.right;
                if(currentNode == null) {
                    parentNode.right = newNode;
                    return;
                }
            }
        }
    }

    public static void insert(Data data){
        Node newNode = new Node(data);

        if(root == null){
            root = newNode;
            return;
        }

        Node currentNode = root;
        Node parentNode;

        while(true){
            parentNode = currentNode;

            if(data.x < currentNode.data.x){
                currentNode = currentNode.left;

                if(currentNode == null){
                    parentNode.left = newNode;
                    return;
                }
            } else {
                currentNode = currentNode.right;

                if(currentNode == null){
                    parentNode.right = newNode;
                    return;
                }
            }
        }
    }

}
