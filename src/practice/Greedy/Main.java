package practice.Greedy;

import java.util.ArrayList;
import java.util.Arrays;

/*
    한계: 반드시 최적의 해를 구할 수 있는 것은 아님

    <문제>
    지불해야 하는 값이 4720원일 때, 10원, 50원, 100원, 500원 동전으로 동전 수가 가장 적게 지불하게끔 구현
    <접근>
    가장 큰 동전부터 최대한 지불해야 하는 값을 채우는 방식으로 구현
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> coinList = new ArrayList<Integer>(Arrays.asList(500, 100, 50, 10));
        ArrayList<Integer> details = new ArrayList<Integer>();

        int price = 4720;
        int totalCoinCount = 0;
        int coinNum = 0;

        for(int i = 0; i < coinList.size(); i++){
            coinNum = price / coinList.get(i); // 몫 = 동전개수
            totalCoinCount += coinNum;
            price -= coinNum * coinList.get(i);
            details.add(coinNum);

            System.out.println(coinList.get(i) + "원: " + coinNum + "개");
        }

        System.out.println("총 동전 갯수: " + totalCoinCount);
    }
}
