package SummerWinterCoding;

class Solution {
    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(12));
        System.out.println(solution(11));
        System.out.println(solution(13));
    }

    public static boolean solution(int x) {
        int div = 0;
        boolean answer = true;
        String y = Integer.toString(x);

        for(int i = 0; i < y.length(); i++){
            div = div + (y.charAt(i)-'0');
        }

        if((x % div) != 0){
            answer = false;
        }
        return answer;
    }
}