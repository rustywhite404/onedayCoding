package hh99_3week.advance;

import java.io.*;
import java.util.Stack;

public class solve2504 {
    /*
     * 문제 분석 :
     * - 괄호열이 바르게 정의되어 있는지 확인한다.
     * - 바르게 정의된 괄호열이라면 미리 정의해 둔 괄호값들로 계산하여 전체 괄호열의 값을 출력한다.
     *
     * 풀이 전략 :
     * - 옳은 괄호열인지 찾는 것까지는 스택을 사용해서 쉽게 풀 수 있을 것 같고
     * - 괄호값 계산은 각 괄호가 입력될 때 마다 값을 곱해서 표현 할 수 있을 것 같은데 해봐야 알 것 같다
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine();
        int result = CorrectedValueReturn(word);
        bw.write(result+" ");
        bw.flush();
        bw.close();

    }

    public static int CorrectedValueReturn(String word) {
        Stack<Character> stack = new Stack<>();
        int temp = 1; //곱셈을 저장할 값
        int result = 0; //최종 결과값

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (ch == '(') {
                stack.push(ch);
                temp *= 2;
            } else if (ch == '[') {
                stack.push(ch);
                temp *= 3;
            } else if (ch == ')') {
                // 잘못된 값인지 먼저 확인
                if (stack.isEmpty() || stack.peek() != '(') {
                    return 0;
                }
                //옳은 값 - 문자열의 직전 값이 (일 경우
                if(word.charAt(i-1)=='('){
                    result += temp; //result에 temp값 반영
                    //옳은 값이지만 문자열 직전의 값이 )일 경우 result에 값 변경 없이 진행
                }
                stack.pop();
                temp /= 2;

            } else if (ch == ']') {
                // 잘못된 값인지 먼저 확인
                if (stack.isEmpty() || stack.peek() != '[') {
                    return 0;
                }
                //옳은 값 - 문자열의 직전 값이 [일 경우
                if(word.charAt(i-1)=='['){
                    result += temp; //result에 temp값 반영
                } //옳은 값이지만 문자열 직전의 값이 )일 경우 result에 값 변경 없이 진행
                    stack.pop();
                    temp /= 3;//괄호 하나가 사라지므로 중첩 제거
            }
        }
        if (!stack.isEmpty()) {
            return 0;
        }
        return result;
    }
}
