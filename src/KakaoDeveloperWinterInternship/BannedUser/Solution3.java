package KakaoDeveloperWinterInternship.BannedUser;

/*
    참고 출처: https://dding9code.tistory.com/105
 */

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Solution3 {
    static HashSet<HashSet<String>> answer;

    public int solution(String[] user_id, String[] banned_id){
        answer = new HashSet<>();

        dfs(new LinkedHashSet<>(), user_id, banned_id);

        return answer.size();
    }

    private static void dfs(HashSet<String> hs, String[] user_id, String[] banned_id){
        //만들어진 불량 사용자 리스트가 주어진 불량사용자 리스트와 맞는지 확인
        if (hs.size() == banned_id.length) {
            if(isBanList(hs, banned_id)) {
                answer.add(new HashSet<>(hs));
            }
            return;
        }

        for(String userId: user_id){
            if(hs.add(userId)) {
                dfs(hs, user_id, banned_id);
                hs.remove(userId);
            }
        }
    }

    private static boolean isBanList(HashSet<String> hs, String[] banned_id){
        int idx = 0;
        for (String userId: hs){
            String baniId = banned_id[idx++];
            if(userId.length() != baniId.length()){
                return false;
            }
            for(int i = 0; i < baniId.length(); i++){
                if(baniId.charAt(i) == '*') {
                    continue;
                }
                if(userId.charAt(i) != baniId.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }
}


