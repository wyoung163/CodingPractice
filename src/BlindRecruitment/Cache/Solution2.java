package BlindRecruitment.Cache;

import java.util.*;

//Queue, 90% accuracy
class Solution2 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> cache = new LinkedList<>();

        for(String city: cities){

            if(cache.contains(city.toLowerCase())){
                cache.remove(city.toLowerCase());
                answer += 1;
            }

            else {
                answer += 5;
                if (cache.size() == cacheSize){
                    cache.poll();
                }
            }

            cache.add(city.toLowerCase());
        }

        return answer;
    }
}