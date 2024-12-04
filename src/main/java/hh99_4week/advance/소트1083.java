package hh99_4week.advance;

import java.io.*;
import java.util.*;

public class 소트1083 {
    /*
     * 입력 :
     * - 배열의 크기 N
     * - 배열 숫자 N개
     * - 교환 횟수
     *
     * 연산 :
     * - List를 sort하는데 Comparator를 중간에 종료시키는 방식으로 가능할 지 테스트
     * => Comparator는 비교만 해주는 함수이므로 내부에서 정렬 상태를 조작하는 데에는 적합하지 않다
     * => 배열로 바꿨다가 list로 바꿨다가 여러가지 방법으로 시도했는데 일단 Collections.swap을 써서 편하게 구현하려고 list로 결정함
     *
     * 출력 :
     * - 문제의 정답 배열을 출력
     *
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int changeCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < total && changeCount > 0; i++) { //i가 total보다 작고, 남은 교환 횟수가 0보다 큰 동안
            //i부터 changeCount범위 내에서 가장 큰 값 찾기
            int maxIdx = i; //최댓값의 위치 저장
            for (int j = i + 1; j < total && j <= i + changeCount; j++) {
                //j는 i 바로 뒤에서부터 탐색 시작
                //탐색 범위는 i+1에서 최대 i+changeCount까지로 제한(=> changeCount가 교환 할 수 있는 최대 거리이므로)
                if (list.get(j) > list.get(maxIdx)) {
                    //현재 j위치의 값이 maxIdx 위치의 값보다 크면, 최댓값의 위치를 변경
                    maxIdx = j;
                    //탐색이 끝나면 maxIdx에 현재 가용 범위에서 가장 큰 값의 위치가 들어있음
                }
            }
            // 이제 가장 큰 값maxIdx를 현재 위치로 이동시켜야 함
            for (int j = maxIdx; j > i; j--) {
                Collections.swap(list, j, j - 1);
                //j위치의 값과 바로 앞 위치의 값을 교환
                //ex. 리스트 [3,5,6,2,4] 에서 j=2라면
                //list[2]와 list[1]을 교환 => [3,6,5,2,4]
                changeCount--;
            }
        }

        for (int i : list) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();

    }
}
