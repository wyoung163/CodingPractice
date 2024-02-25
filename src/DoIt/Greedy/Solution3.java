package DoIt.Greedy;

import java.util.Scanner;

/*
    036
    문자열 쪼개는 방법 익히기
 */
public class Solution3 {
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ex = sc.nextLine();
        String[] str = ex.split("-");
        for(int i = 0; i < str.length; i++){
            int temp = sum(str[i]);
            if(i == 0){
                answer = answer + temp;
            } else {
                answer = answer - temp;
            }
        }
        System.out.println(answer);
    }

    static int sum(String a){
        int sum = 0;
        String temp[] = a.split("[+]");
        for(int i = 0; i < temp.length; i++){
            sum += Integer.parseInt(temp[i]);
        }
        return sum;
    }
}
