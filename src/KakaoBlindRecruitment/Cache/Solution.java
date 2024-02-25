package KakaoBlindRecruitment.Cache;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0, j = 0;

        String[] saves = new String[cacheSize];

        if(cacheSize == 0){
            answer += 5 * cities.length;
        }

        for(String x : cities){
            for(int i = 0; i < cacheSize; i++){
                //System.out.println(saves[i] + " and " + x);
                if(saves[i] != null && x != null && saves[i].equalsIgnoreCase(x)){
                    while(-1 < i && i < cacheSize-1){
                        saves[i] = saves[i+1];
                        i++;
                    }
                    saves[cacheSize-1] = x;
                    answer += 1;
                    break;
                } else {
                    if(saves[i] == null){
                        saves[i] = x;
                        answer += 5;
                        break;
                    }
                    if(i == cacheSize-1){
                        j = 0;
                        while(-1 < j && j < cacheSize-1){
                            saves[j] = saves[j+1];
                            j++;
                        }
                        saves[i] = x;
                        answer += 5;
                        break;
                    }
                }
            }

        }
        return answer;
    }
}