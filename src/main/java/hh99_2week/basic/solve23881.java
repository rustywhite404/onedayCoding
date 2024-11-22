package hh99_2week.basic;

import java.io.*;
import java.util.StringTokenizer;

public class solve23881 {
    /*
    - 문제 분석 :
    - 첫 줄에 배열의 크기 N, 교환 횟수 K가 주어진다.
    - 다음 줄에 배열 안의 원소들이 각각 주어진다.
    - 선택 정렬로 배열을 오름차순 정렬할 예정이다.
    - K번째로 교환되는 두 개의 수를, 작은 수부터 한 줄에 출력한다.
    - 교환 횟수가 K보다 작으면 -1을 출력한다.
    - 풀이 전략 :
    - 선택정렬을 구현하며 K번째의 값들을 출력한다.

    - 이렇게 구현해도 정상적으로 결과값이 나오지만, 문제에서 제시한 의사코드대로 푼 게 아니라 틀렸다고 나오는 것 같다.
    - 문제의 의사코드를 그대로 구현해서 다시 작성해보자.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int total = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int[] nums = new int[total];
        int currentCount = 0;
        st = new StringTokenizer(br.readLine(), " ");
        //배열에 입력받은 값 넣기
        for (int i = 0; i < total; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        //배열을 오름차순 정렬
        for (int i = 0; i < total - 1; i++) {
            //최솟값 인덱스
            int minIndex = i;

            //현재 위치 이후에서 최솟값 찾기
            for (int j = i + 1; j < total; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            //최솟값과 현재 위치 교환
            if (minIndex != i) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;

                // 교환 횟수 증가
                currentCount++;

                if (currentCount == count) {
                    int a = Math.min(nums[i], nums[minIndex]);
                    int b = Math.max(nums[i], nums[minIndex]);
                    bw.write(a + " " + b);
                    bw.flush();
                    bw.close();
                    return; //프로그램 종료
                }

            }

        }
        // K번째 교환이 없었으면 -1 출력
        bw.write("-1");
        bw.flush();
        bw.close();

    }
}
