package practice.Hiding_PhoneNumber;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("01033334444"));
    }

    public static String solution(String phone_number) {
        String answer = "";
        int length = phone_number.length();
        for(int i = 0; i < length-4; i++){
            answer += "*";
        }
        answer = answer + phone_number.substring(phone_number.length()-4, phone_number.length());
        return answer;
    }
}
