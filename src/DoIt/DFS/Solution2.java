package DoIt.DFS;

import java.util.Scanner;

//024 신기한 소수, DFS
public class Solution2 {
    static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    static void DFS(int num, int pos) {
        if (pos == n) {
            if (isPrime(num)) {
                System.out.println(num);
            }
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0)
                continue;
            if(isPrime(num * 10 + i))
                DFS(num * 10 + i, pos + 1);
        }
    }
    static boolean isPrime(int num) {
        for(int i = 2; i <= num / 2; i++){
            if(num % i == 0)
                return false;
        } return true;
    }
}

