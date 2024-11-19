package hh99_1week.plus;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class solve27497_re {
    /*
    문제 분석 :
    - 문자열 맨 뒤에 블록 추가 기능
    - 문자열 맨 앞에 블록 추가 기능
    - 맨 마지막에 추가된 블록 제거 기능
    - 버튼을 다 누른 후 완성된 문자열 출력

    풀이 전략 :
    - Deque를 이용하여 구현. addFirst(), addLast(), removeLast()를 사용하자.
    - => 1과 2 버튼은 잘 구현이 되었지만 3번 버튼을 구현하려니 적절하지 않았다(다른 예제들은 다 정상적으로 작동하는데 1번 예제가 계속 결과가 이상했다)
    - Stack을 이용해서 다시 구현했다. => 2번처럼 앞에 요소를 추가할 때 비효율 적이다. 그래서인지 시간초과 발생
    - 다시 Deque로 돌아와서, 대신 입출력 시 추가된 명령을 기록하는 stack을 함께 사용했다.
    - stack을 통해 앞에 입력했는지 뒤에 입력했는지를 구분해서 처리함.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int count = Integer.parseInt(br.readLine());
        Deque<String> deque = new LinkedList<>();
        Stack<Integer> operationStack = new Stack<>(); // 추가된 명령을 추적하는 스택

        // 각 버튼을 누를 때마다 덱을 업데이트
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String order = st.nextToken();

            switch (order) {
                case "1":
                    deque.addLast(st.nextToken()); // 덱의 뒤에 추가
                    operationStack.push(1); // 추가된 명령 기록
                    break;
                case "2":
                    deque.addFirst(st.nextToken()); // 덱의 앞에 추가
                    operationStack.push(2); // 추가된 명령 기록
                    break;
                case "3":
                    if (!deque.isEmpty()) {
                        if (!operationStack.isEmpty()) {
                            int lastOperation = operationStack.pop();
                            if (lastOperation == 1) {
                                deque.removeLast(); // 뒤에서 제거
                            } else if (lastOperation == 2) {
                                deque.removeFirst(); // 앞에서 제거
                            }
                        }
                    }
                    break;
            }
        }

        if (deque.isEmpty()) {
            bw.write("0");
        } else {
            for (String s : deque) {
                bw.write(s);
            }
        }
        bw.flush();
        bw.close();
    }
}
