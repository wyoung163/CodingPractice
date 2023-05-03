package BlindRecruitment.CompressString;

//참고: https://velog.io/@ckr3453/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%AC%B8%EC%9E%90%EC%97%B4-%EC%95%95%EC%B6%95-Java
class Solution2 {
    public int solution(String s) {
        int answer = s.length(), cnt = 1;

        for(int i = 1; i <= s.length()/2; i++){
            StringBuilder result = new StringBuilder();
            String base = s.substring(0, i);
            for(int j = i; j <= s.length(); j+=i){
                int idx = Math.min(j+i, s.length());
                String compare = s.substring(j, idx);
                if(base.equals(compare)){
                    cnt++;
                } else {
                    if(cnt >=2){
                        result.append(cnt);
                    }
                    result.append(base);
                    base = compare;
                    cnt = 1;
                }
            }
            result.append(base);
            answer = Math.min(answer, result.length());
        }
        return answer;
    }
}