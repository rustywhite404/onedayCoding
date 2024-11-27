package hh99_3week.basic;

import java.io.*;
import java.util.Stack;

public class solve4949_re {
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
        while (!(word = br.readLine()).equals(".")) { // "."가 들어오기 전까지 반복
            Stack<Character> stack = new Stack<>();
            boolean isBalanced = true;
            //각 문자열을 받아 자릿수만큼 반복한다
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                //(나 [가 들어오면 스택에 입력한다
                if (ch=='(' || ch=='[') {
                    stack.push(ch);
                }

                //)나 ]가 들어왔을 때 스택이 비어있으면 no 출력
                if (ch==')' || ch==']') {
                    if (stack.isEmpty()){
                        isBalanced = false;
                        break;
                    }
                    char top = stack.peek();
                    if (ch == ')' && top == '(' || ch == ']' && top=='[') {
                        stack.pop();
                    }else {
                        isBalanced = false;
                        break;
                    }
                }
            }
            if (stack.isEmpty() && isBalanced) {
                bw.write("yes");
            } else {
                bw.write("no");
            }
            bw.newLine();

        }
        bw.flush();
        bw.close();
    }
}
