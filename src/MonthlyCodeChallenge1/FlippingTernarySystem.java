package MonthlyCodeChallenge1;

public class FlippingTernarySystem {
    public int solution(int n) {
        int answer = 0;

        n = conversion(n, 3);
        answer = reverseNumber(n);
        answer = converse_ten(Integer.toString(answer), 3);

        return answer;

    }

    public int conversion(int number, int k) {
        StringBuilder sb = new StringBuilder();
        int current = number;

        while (current > 0) {
            if (current % k < 10) {
                sb.append(current % k);
            } else {
                sb.append((char) (current % k - 10 + 'A'));
            }
            current /= k;
        }
        System.out.println("숫자 : " + number + "를 " + k + "진법으로 변환한 수 : " + sb.reverse());
        return Integer.parseInt(sb.toString());
    }

    public int converse_ten(String number, int N) {
        char[] nums = number.toCharArray();
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 'A') {
                ans = ans * N + (nums[i] - 'A' + 10);
            } else {
                ans = ans * N + (nums[i] - '0');
            }
        }
        System.out.println(ans);
        return ans;
    }

    public int reverseNumber(int n) {
        int rev = 0;
        while (n != 0) {
            rev = (rev * 10) + (n % 10);
            n /= 10;
        }
        return rev;
    }

}
