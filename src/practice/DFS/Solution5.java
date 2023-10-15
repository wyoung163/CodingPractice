package practice.DFS;

/*
    DFS 모음사전
    중복을 허용하는 DFS
 */
class Solution5 {
    //static boolean visited[];
    static int answer, tmp;
    static String[] str;
    public int solution(String word) {
        answer = 0;
        str = new String[5];
        str[0] = "A";
        str[1] = "E";
        str[2] = "I";
        str[3] = "O";
        str[4] = "U";
        //visited = new boolean[word.length()];

        tmp = 0;
        dfs("", word);

        return answer;
    }

    public static void dfs(String s, String toFind){
        if(s.equals(toFind)) {
            answer = tmp;
            return;
        }
        ++tmp;
        if(s.length() >= 5) return;

        for(int i = 0; i < 5; i++){
            dfs(s+str[i], toFind);
        }
    }
}
