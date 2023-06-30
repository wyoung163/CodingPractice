package DoIt.SegmentTree;

import javax.imageio.event.IIOWriteProgressListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    071 구간 합 구하기 3
    세그먼트 트리(주어진 데이터들의 구간 합과 데이터 업데이트를 빠르게 수행하기 위해 고안해낸 자료구조)
    더 큰 범위는 인덱스 트리이지만 코테 영역에서는 큰 차이 없음
    <종류> 구간 합, 최대+최소 구하기
    <구현 단계> 트리 초기화하기, 질의값 구하기(구간 합 또는 최대+최소), 데이터 업데이트 하기
 */
public class Solution {
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 수의 개수
        int m = Integer.parseInt(st.nextToken()); // 변경이 일어나는 횟수
        int k = Integer.parseInt(st.nextToken()); // 구간의 합을 구하는 횟수
        int height = 0; // 트리의 높이
        int length = n;
        while(length != 0){
            length /= 2;
            height++;
        }
        int size = (int) Math.pow(2, height + 1); // 트리 사이즈: 2의 K승 >= N을 만족하는 K(height)값
        int leftNodeStartIdx = size / 2 - 1; // 리프 노드 시작 인덱스
        tree = new long[size + 1];
        // 데이터 리프 노드에 입력
        for(int i = leftNodeStartIdx + 1; i <= leftNodeStartIdx + n; i++){
            tree[i] = Long.parseLong(br.readLine());
        }
        setTree(size - 1);
        for(int i = 0; i < m+k; i++){
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            long e = Integer.parseInt(st.nextToken());
            if(a == 1)
                changeVal(leftNodeStartIdx + s, e);
            else if(a == 2){
                s += leftNodeStartIdx;
                e += leftNodeStartIdx;
                System.out.println(getSum(s, (int) e));
            } else
                return;
        }
        br.close();
    }
    private  static long getSum(int s, int e){
        long partSum = 0;
        while(s <= e){
            if(s % 2 == 1){
                //해당 노드의 부모가 타나내는 범위가 질의 범위를 나타내기 때문에 해당 노드를 질의 값에
                //영향을 미치는 독립 노드로 선택
                partSum += tree[s];
                s++;
            }
            if(e % 2 == 0){
                //해당 노드의 부모가 타나내는 범위가 질의 범위를 나타내기 때문에 해당 노드를 질의 값에
                //영향을 미치는 독립 노드로 선택
                partSum += tree[e];
                e--;
            }
            //부모 노드로 이동
            s /= 2;
            e /= 2;
        }
        return partSum;
    }

    private static void changeVal(int idx, long val){
        long diff = val - tree[idx];
        while(idx > 0){
            tree[idx] = tree[idx] + diff;
            idx /= 2;
        }
    }

    private static void setTree(int i){
        while(i != 1){
            //A[n] = A[2n] + A[2n+1]
            tree[i / 2] += tree[i];
            i--;
        }
    }
}

/*
    1. 트리 초기화하기
    리프 노드 개수 >= 데이터 개수(n)가 되도록 트리 배열 만들기
    트리 배열의 크기: 2의 k승 >= n 만족하는 k의 최솟값 구한 뒤 2의 k승*2 크기로 정의

    2. 질의값 구하기
    주어진 질의 인덱스를 세그먼트 트리의 리프 노드에 해당하는 인덱스로 변경
    세그먼트 트리 idx = 질의 idx + 2의 k승 - 1
    <질의 구하는 과정>
    1. start_idx % 2 == 1일 때 해당 노드 선택
    2. end_idx % 2 == 0일 때 해당 노드 선택
    3. 1, 2에서 노드 선택 안했다면 start_idx = (start_idx + 1) / 2
    4. 1, 2에서 노드 선택 안했다면 end_idx = (end_idx - 1) / 2
    5. 1~4 반복하다 end_idx < start_idx 되면 종료
    * 1~2는 해당 노드를 질의값에 영향을 미치는 독립 노드로 선택하고 해당 노드의 부모
    노드는 대상 범위에서 제외한다는 뜻
    <질의에 해당하는 노드 선택 방법>
    구간 합: 선택된 노드 모두 더하기
    최댓값: 선택된 노드 중 MAX 값 선택해 출력
    최솟값: 선택된 노드 중 MIN 값 선택해 출력

    3. 데이터 업데이트
    자신의 부모 노드로 이동하면서 업데이트
    어떤 값으로 업데이트할 것인지에 대해 트리 타입별로 조금 다름
    부모 노드 이동 idx = idx / 2
    구간 합: 원래 데이터와 변경 데이터 차이만큼 부모 노드로 올라가 변경
    최댓값 찾기: 변경 데이터와 자신과 같은 부모를 지니고 있는 다른 자식 노드와 비교해 더 큰 값으로
    최솟값: 변경 데이터와 자신과 같은 부모를 지니고 있는 다른 자식 노드와 비교해 더 작은 값으로
 */
