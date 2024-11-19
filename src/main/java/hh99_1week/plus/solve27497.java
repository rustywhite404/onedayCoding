package hh99_1week.plus;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class solve27497 {
    /*
    문제 분석 :
    - 문자열 맨 뒤에 블록 추가 기능
    - 문자열 맨 앞에 블록 추가 기능
    - 맨 마지막에 추가된 블록 제거 기능
    - 버튼을 다 누른 후 완성된 문자열 출력

    풀이 전략 :
    - Deque를 이용하여 구현. addFirst(), addLast(), removeLast()를 사용하자.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int count = Integer.parseInt(br.readLine());
        Deque<String> dq = new ArrayDeque<>();

        // 각 버튼을 누를 때마다 덱을 업데이트
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String order = st.nextToken();

            switch (order) {
                case "1":
                    dq.addLast(st.nextToken());  // 덱의 뒤에 추가
                    break;
                case "2":
                    dq.addFirst(st.nextToken());  // 덱의 앞에 추가
                    break;
                case "3":
                    dq.removeLast();  // 덱에서 가장 최근에 추가된 블록 제거 (뒤에서 제거)
                    break;
            }
        }

        // 덱의 모든 요소를 출력
        for (String o : dq) {
            bw.write(o);
        }

        bw.flush();
        bw.close();
    }
}