package practice.DFS;

/*
    거리두기 확인하기
    2021 카카오 채용연계 인턴십
    case 28/31 통과
 */
class Solution3 {
    int[] rx = {0, -1, 0, 1};
    int[] ry = {1, 0, -1, 0};
    int[] vx = {1, -1, 1, -1};
    int[] vy = {1, -1, -1, 1};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for(int i = 0; i < 5; i++){
            boolean can = dfs(places[i]);
            if(!can) {answer[i] = 0;}
            else answer[i] = 1;
        }

        return answer;
    }

    private boolean dfs(String[] places){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(places[i].charAt(j) == 'P'){
                    //rx, ry가 1인 경우
                    for(int k = 0; k < 4; k++){
                        int dx = i + rx[k];
                        int dy = j + ry[k];
                        if(dx >= 0 && dx < 5 && dy >= 0 && dy < 5){
                            if(places[dx].charAt(dy) == 'P'){
                                return false;
                            }
                        }
                    }

                    //rx, ry가 2인 경우
                    for(int k = 0; k < 4; k++){
                        int dx = i + rx[k]*2;
                        int dy = j + ry[k]*2;
                        if(dx >= 0 && dx < 5 && dy >= 0 && dy < 5){
                            if(places[dx].charAt(dy) == 'P'){
                                if(rx[k] > 0 && places[dx-1].charAt(dy) != 'X'){
                                    return false;
                                } else if(rx[k] < 0 && places[dx+1].charAt(dy) != 'X'){
                                    return false;
                                } else if(ry[k] > 0 && places[dx].charAt(dy-1) != 'X'){
                                    return false;
                                } else if(ry[k] < 0 && places[dx].charAt(dy+1) != 'X'){
                                    return false;
                                }
                            }
                        }
                    }

                    //대각선
                    for(int k = 0; k < 4; k++){
                        int dx = i + vx[k];
                        int dy = j + vy[k];
                        if(dx > 0 && dx < 4 && dy > 0 && dy < 4){
                            if(places[dx].charAt(dy) == 'P'){
                                if(vx[k] > 0 && vy[k] > 0 && (places[dx-1].charAt(dy) != 'X' || places[dx].charAt(dy-1) != 'X')){
                                    return false;
                                } else if(rx[k] < 0 && vy[k] > 0 && (places[dx+1].charAt(dy) != 'X' || places[dx].charAt(dy-1) != 'X')){
                                    return false;
                                } else if(ry[k] > 0 && vy[k] < 0 && (places[dx-1].charAt(dy) != 'X' || places[dx].charAt(dy+1) != 'X')){
                                    return false;
                                } else if(ry[k] < 0 && vy[k] < 0 && (places[dx+1].charAt(dy) != 'X' || places[dx].charAt(dy+1) != 'X')){
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}