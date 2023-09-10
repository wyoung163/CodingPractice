package practice.Scenario;

//2차원 배열에서 이동하는 방법에 대해 고민하기, 배열 테트리스 처럼 줄이는 방법 이해하기
import java.util.*;
class Solution {
    static private char[][] map;
    static private int answer = 0;
    static private class Vertex {
        int x, y;
        public Vertex(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int m, int n, String[] board) {
        map = new char[m][n];
        for(int i = 0; i < m; i++){
            map[i] = board[i].toCharArray();
            System.out.println(map[i][0]);
        }
        while(true){
            // 2x2 블록 지우고 블록이 지워졌는지 안지워졌는지 검사
            // 안지워졌으면 false 반환 - 더 이상 지울 블록 없음
            if(!removeAndCheck()) break;
            rearrange();
        }
        return answer;
    }

    public static boolean removeAndCheck() {
        int cnt = 0;
        HashSet<Vertex> set = new HashSet();

        for(int i=0; i<map.length-1; i++) {
            for(int j=0; j<map[0].length-1; j++) {
                if(map[i][j]=='.') continue;//이미 지운블록 건너뜀.
                //같은 블록들이 2x2를 이룰때 set에 위치 저장.
                if(map[i][j]==map[i][j+1] && map[i][j+1]==map[i+1][j+1] && map[i+1][j+1]==map[i+1][j]) {
                    set.add(new Vertex(i,j));
                    set.add(new Vertex(i,j+1));
                    set.add(new Vertex(i+1,j+1));
                    set.add(new Vertex(i+1,j));
                }
            }
        }

        Iterator<Vertex> iter = set.iterator();
        while(iter.hasNext()){
            Vertex v = iter.next();
            if(map[v.x][v.y] == '.'){
                continue;
            } else {
                if(map[v.x][v.y] != '.'){
                    cnt++;
                    map[v.x][v.y] = '.';
                }
            }
        }
        answer += cnt;
        if(cnt == 0) return false;
        return true;
    }

    public static void rearrange(){
        for(int j = 0; j < map[0].length; j++){
            int space = 0; // 비워진 공간 수
            for(int i = map.length-1; i >= 0; i--){
                if(map[i][j] == '.') space++;
                    //블록이 있고 이전에 빈공간이 있었다면 빈공간 만큼 블록 내리고 원래 위치는 빈공간으로
                else if(map[i][j]!='.' && space != 0){
                    map[i+space][j] = map[i][j];
                    map[i][j] = '.';
                }
            }
        }
    }

}