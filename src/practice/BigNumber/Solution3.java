package practice.BigNumber;

//다시 도전할 문제
public class Solution3 {
    public String solution(String number, int k){
        String answer = "";
        StringBuilder sb = new StringBuilder();
        char[] arr = number.toCharArray();
        int len = arr.length - k;

        int start = 0;
        for(int i = 0; i < len; i++){
            char max = '0';
            for(int j = start; j <= i + k; j++){
                if(max < arr[j]) {
                    max = arr[j];
                    start = j + 1;
                }
            }
            sb.append(Character.toString(max));
        }

        answer = sb.toString();
        return answer;
    }
}
