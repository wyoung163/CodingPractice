package KakaoDeveloperWinterInternship.BannedUser;

//banned_id에 순서에 관계없이 중복될 수 있는 경우의 수를 고려하지 않아도 될 때 가능한 솔루션
class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 1, wordLength = 0, k = 0, count = 0;
        int banLength = banned_id.length;
        int[] save = new int[banLength];

        for(int i = 0; i < banLength ; i++){
            wordLength = banned_id[i].length();
            Loop1 :
            for(int j = 0; j < user_id.length; j++){
                if(banned_id[i].length() == user_id[j].length()){
                    Loop2 :
                    while(k < wordLength){
                        if(banned_id[i].charAt(k) == '*' ||
                                banned_id[i].charAt(k) == user_id[j].charAt(k)){
                            //System.out.println("k = " + k);
                            k++;
                        }
                        else break Loop1;
                    }
                    k = 0;
                    ++save[i];
                    /*
                    System.out.println("i = " + i);
                    System.out.println("j = " + j);
                    System.out.println("save = " +  save[i]);
                     */
                }
            }
        }

        for(int i = 0; i < banLength; i++){
            //System.out.println("save = " +  save[i]);
            answer *= save[i];
            //System.out.println("answer = " +  answer);
        }
        return answer;
    }
}