package BlindRecruitment.CompressString;

class Solution {
    public int checkSame(String s, int n){
        int isSame = -1;
        String result= "";

        result = s.substring(0,n);
        System.out.println(result);
        System.out.println(s.substring(n,2*n));
        System.out.println(result.equals(s.substring(n,2*n)));

        if(result.equals(s.substring(n,2*n))) {
            isSame = 1;
        } else {
            isSame = 0;
        }

        return isSame;
    }

    public String getResult(String s, int n){
        String result= "", answer ="";
        int count = 1;
        int num = 0;

        result = s.substring(0,n);
        for(int l = n; l+n - 1 < s.length(); l=l+n){
            System.out.println("result " + result);
            System.out.println("s.substring(l,l+n) " + s.substring(l,l+n));

            if(result.equals(s.substring(l,l+n))) {
                System.out.println("count: " + count);
                count++;
                if(count > 2){
                    answer = Integer.toString(count) + result;
                    System.out.println("answer0: " + answer);
                } else {
                    answer = answer + Integer.toString(count) + result;
                    System.out.println("answer00: " + answer);
                }
                System.out.println("answer: " + answer);
                num++;
            } else if(!result.equals(s.substring(l-num*n,l-(num-1)*n))){
                answer = answer + result;
                System.out.println("answer2: " + answer);
            } else {
                if(l+2*n > s.length()){
                    answer = answer + s.substring(l);
                    System.out.println("answer3: " + answer);
                }
                result = s.substring(l,l+n);
                count = 1;
            }
        }
        return answer;
    }

    public int solution(String s) {
        int answer = 0;
        int isTrue = -1;
        int count = 1;

        for(int i = s.length() / 2; i > 0; i--){
            isTrue = checkSame(s, i);

            if(isTrue == 1){
                String sent = getResult(s, i);
                answer = sent.length();
                break;
            }
        }

        if(answer == 0){
            return s.length();
        }
        return answer;
    }
}