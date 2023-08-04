package DoIt.Combination;

import java.io.IOException;
import java.util.Scanner;

/*
    082 사전 찾기
    경우의 수를 나열했을 때 k번 째 찾기
    081 순열 순서와 동일한 원리인데 여전히 이해가 어려움
 */
public class Solution6 {
    static int n, m, k;
    static int[][] D;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        D = new int[202][202];
        for(int i = 0; i <= 200; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i)
                    D[i][j] = 1;
                else {
                    D[i][j] = D[i-1][j-1] + D[i-1][j];
                    if(D[i][j] > 1000000000) D[i][j] = 1000000001; //k 범위 넘어가면 범위 최댓값 저장
                }
            }
        }
        if(D[n+m][m] < k) //주어진 자릿수로 만들 수 없는 k번째 수
            System.out.println("-1");
        else{
            while(!(n == 0 && m == 0)){
                //a를 선택했을 때 남은 문자로 만들 수 있는 모든 경우의 수가 k보다 크면
                if(D[n-1+m][m] >= k){
                    System.out.println("a");
                    n--;
                } else {
                    System.out.println("k");
                    k = k - D[n-1+m][m];
                    m--;
                }
            }
        }
    }
}

/*
    <이해를 돕기 위한 설명 추가>
    a 문자 3개, z 문자 2개, k = 4일 때 경우의 수 나열
    1. aaazz
    2. aazaz
    3. aazza
    4. azaaz
    5. azaza
    6. azzaa
    7. zaaaz
    ....
    a로 시작하는 문자열의 개수가 6이니 6 이하 번째 수는 a로 시작
    aa로 시작하는 문자열의 개수는 3개이니 4번 째 문자열은 aa로 시작할 수 없음
    az로 시작하는 4-6 경우의 수 중 고르면 됨
    따라서 aa의 세 경우의 수를 빼주면 되기 떄문에
    >>> k = k - D[n-1+m][m]와 같은 과정이 필요한 것
    또한
    >>> (D[n-1+m][m] >= k)와 같은 과정도 a문자가 삽입될 때 가능한 문자열의 수를 판단해 지금 자릿 수에
    a가 올지, z가 올지를 결정하기 위한 과정
 */