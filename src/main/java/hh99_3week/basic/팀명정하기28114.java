package hh99_3week.basic;


import java.io.*;
import java.util.*;

public class 팀명정하기28114 {
    /*
     * 입력 :
     * - 1번팀원이 해결한 문제의 수 P, 입학연도 Y, 성씨 S가 공백으로 구분되어 주어짐
     * - 2, 3번 줄도 동일하다. 팀원은 모두 세 명 까지 주어진다.
     *
     * 연산 :
     * - A: 세 참가자의 입학연도를 100으로 나눈 나머지를 오름차순 정렬해서 이어붙인 문자열
     * - => 나머지를 우선순위 큐에 String 형으로 저장해서 문자열을 이어붙인다
     * - B: 해결한 문제 수가 많은 사람의 성씨 첫글자 순으로 나열한 문자열
     *   => 키,값 쌍으로 <성씨,해결한 문제 수>
     * - 출력:
     * - A와 B 방식으로 만든 팀명을 한 줄씩 출력한다
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        PriorityQueue<String> yearSorted = new PriorityQueue<>();
        PriorityQueue<Map.Entry<Character, Integer>> solverSorted = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int solvedCount = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            char firstName = st.nextToken().charAt(0);

            //A방법으로 팀 이름 작성
            String yearToString = String.valueOf(year % 100);
            yearSorted.add(yearToString);

            //B방법으로 팀 이름 작성
            solverSorted.add(new AbstractMap.SimpleEntry<>(firstName, solvedCount));

        }

        while (!yearSorted.isEmpty()) {
            bw.write(yearSorted.poll());
        }

        bw.newLine();

        while (!solverSorted.isEmpty()) {
            bw.write(solverSorted.poll().getKey());
        }
        bw.flush();
        bw.close();
    }
}
