package KakaoDeveloperWinterInternship.BannedUser;

/*
    순서, 중복을 무시하기 위해 중복되는 수 count하는 법 추가
    어떤 banned_id들끼리 중복될 수 있는 id를 가질 수 있는지, 그 id쌍 끼리 중북되는 id 수를 몇 개 가지는지 알 수 없는 문제점 미해결
 */

class Solution2 {
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 1, count = 0, wordLength = 0, k = 0, ssang = 0;
        int[][] arr = new int[banned_id.length][user_id.length];
        int[] save = new int[banned_id.length];

        for(int i = 0; i < banned_id.length; i++){
            wordLength = banned_id[i].length();
            for(int j = 0; j < user_id.length; j++){
                if(wordLength == user_id[j].length()){
                    while(k < wordLength){
                        if(banned_id[i].charAt(k) == '*' ||
                                banned_id[i].charAt(k) == user_id[j].charAt(k)){
                            ++k;
                            arr[i][j] = 1;
                            if(i > 0 && k == wordLength-1){
                                if(arr[i][j] == arr[i-1][j] && arr[i][j] == 1){
                                    ++count;
                                }
                            }
                        }
                        else break;
                    }
                    if(k == wordLength){
                        k = 0;
                        ++save[i];
                    }
                }
            }
        }

        for(int i = 0; i < banned_id.length; i++){
            answer *= save[i];
        }

        if(count > 0){
            answer = answer/factorial(count);
        }
        return answer;
    }

    public int factorial (int num) {
        if (num == 1)
            return 1;

        return num * factorial ( num - 1 );
    }
}