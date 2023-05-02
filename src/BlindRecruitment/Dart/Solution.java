package BlindRecruitment.Dart;

class Solution {
    public int solution(String dartResult) {
        int answer = 0, cal = 0, n = 0;
        char[] ch = dartResult.toCharArray();
        int[] num = new int[5];
        for(int i = 0; i < ch.length; i++){
            if(String.valueOf(ch[i]).matches("[0-9]")){
                if(cal != 0){
                    num[n++] = cal;
                }
                cal = Integer.parseInt(String.valueOf(ch[i]));
                // 두자리 수
                if(String.valueOf(ch[i+1]).matches("[0-9]")) {
                    cal *= 10;
                    i++;
                }
            } else if(ch[i] == 'S'){
                continue;
            } else if(ch[i] == 'D'){
                cal = (int)Math.pow(cal, 2);
            } else if(ch[i] == 'T'){
                cal = (int)Math.pow(cal, 3);
            } else if(ch[i] == '*'){
                if(n > 0){
                    num[n-1] *= 2;
                }
                cal *= 2;
            } else if(ch[i] == '#'){
                cal *= -1;
            }
        }
        num[n] = cal;
        for(int i = 0; i < 3; i++){
            System.out.println(answer);
            answer += num[i];
        }
        return answer;
    }
}