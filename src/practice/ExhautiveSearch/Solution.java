package practice.ExhautiveSearch;

import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {


    }

    public long solution(int w, int h){
        long ref = gcd(w, h);
        return ((long) w * h) - ((w / ref) + (h/ref) -1) * ref;
    }

    private int gcd(int n, int m){
        while(m != 0){
            int r = n % m;
            n = m;
            m = r;
        }
        return n;
    }

    private int gcd2 (int n, int m){
        while(m!=0){
            int r = n % m;
            n = m;
            m = r;
        }
        return n;
    }
}
