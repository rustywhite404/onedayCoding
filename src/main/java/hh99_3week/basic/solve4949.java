package hh99_3week.basic;

import java.io.*;
import java.util.Stack;

public class solve4949 {
    /*
     * 문제 해석 :
     * - 문자열이 주어졌을 때, 이 문자열에 포함된 (와 ), [와 ]를 찾는다
     * - 모든 문자열의 괄호들이 제대로 된 짝이 있을 경우 균형잡힌 문자열이다
     * - 괄호가 존재하지 않아도 균형잡힌 문자열이다
     * - 입력 종료 시 온점(.)이 들어온다
     *
     * 풀이 전략 :
     * - 온점(.) 하나만 들어오기 전까지 반복문 실행
     * - 각 문자열을 받아 자릿수만큼 반복한다
     * - (나 [가 들어오면 스택에 입력한다
     * - )나 ]가 들어왔을 때 스택이 비어있으면 no 출력
     * - )나 ]가 들어왔을 때 스택 맨 뒤에 (나 [가 있으면 pop
     * - 문자열이 끝났을 때 스택이 비어있으면 yes, 아니면 no
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = "";
        while (!(word = br.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<>();
            boolean isBalanced = true; //균형 여부 플래그

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                } else if (ch == ')' || ch == ']') {
                    // 스택이 비어있으면 짝이 맞지 않음
                    if (stack.isEmpty()) {
                        isBalanced = false;
                        break;
                    }
                    char top = stack.peek(); //스택의 맨 위 값 확인

                    if ((ch == ')' && top == '(') || (ch == ']' && top == '[')) { //짝이 올바르면
                        stack.pop();
                    } else {
                        isBalanced = false;
                        break;
                    }
                }
            }
            //반복문 종료 후 스택이 비어있고 boolean값이 true여야 균형잡힌 문자열
            if (stack.isEmpty() && isBalanced) {
                bw.write("yes");
            }else {
                bw.write("no");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();

    }
}
