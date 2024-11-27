package hh99_3week.advance;

import java.io.*;
import java.util.Stack;

public class solve2504_re {
    /*
     * 문제 분석 :
     * - 괄호열이 바르게 정의되어 있는지 확인한다.
     * - 바르게 정의된 괄호열이라면 미리 정의해 둔 괄호값들로 계산하여 전체 괄호열의 값을 출력한다.
     *
     * 4개의 기호 ‘(’, ‘)’, ‘[’, ‘]’를 이용해서 만들어지는 괄호열 중에서 올바른 괄호열이란 다음과 같이 정의된다.
     *
     * 풀이 전략 :
     * - 옳은 괄호열인지 찾는 것까지는 스택을 사용해서 쉽게 풀 수 있을 것 같고
     * - 괄호값 계산은 각 괄호가 입력될 때 마다 값을 곱해서 표현 할 수 있을 것 같은데 해봐야 알 것 같다
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine();
        int result = calculateBracketValue(word);
        bw.write(result + " ");
        bw.flush();
        bw.close();

    }


    // 올바른 괄호열인지 체크하고 값을 반환하는 메서드
    public static int calculateBracketValue(String word) {
        Stack<Character> stack = new Stack<>();
        int result = 0; // 최종 결과값
        int temp = 1; // 중간 곱셈값

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (ch == '(') {
                stack.push(ch);
                temp *= 2;
            } else if (ch == '[') {
                stack.push(ch);
                temp *= 3;
            } else if (ch == ')') {
                //올바르지 않은 괄호열인 경우 먼저 처리
                if (stack.isEmpty() || stack.peek() != '(') {
                    return 0;
                }

                //직전 입력값이 (였으면 결과값에 현재 temp를 더함
                if(word.charAt(i-1)=='(') result += temp;
                stack.pop();
                temp /= 2; // (가 처리되었으므로 나눔

                // 왜 나눠야 하냐면
                // 괄호열 (())로 예를 들어보자.
                // 처음 ( :
                // temp *= 2 -> temp = 2
                // 스택에 (가 추가된다.
                // 두번째 ( :
                // temp *= 2 -> temp = 4
                // 스택에 또 하나의 (가 추가된다.
                // 첫번째 ) :
                // 이전 문자가 (이므로, 현재의 temp 값을 result에 더한다. result += temp -> result = 4
                // 스택에서 (를 제거한다.
                // 그러면 중첩 상태가 ((에서 (로 바뀌므로, temp에서도 두번째 (가 추가한 값을 제거한다.
                // temp /= 2 -> temp = 2
                // 두번째 ) :
                // 이전에 있던 문자가 (가 아니므로, 더하지 않고 그냥 처리
                // 스택에서 (를 제거하고, 중첩 상태가 (에서 공백으로 바뀌므로 (가 추가한 값을 제거한다.
                // temp /= 2 -> temp = 1.
            } else if (ch == ']') {
                //올바르지 않은 괄호열인 경우 먼저 처리
                if (stack.isEmpty() || stack.peek() != '[') {
                    return 0;
                }
                if(word.charAt(i-1)=='[') result += temp;
                stack.pop();
                temp /= 3; // [가 처리되었으므로 나눔
            }
        }

        //스택이 비어있지 않다면 올바르지 않은 괄호열
        if (!stack.isEmpty()) return 0;

        return result;
    }
}
