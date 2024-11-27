package hh99_3week.basic;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 단어순서뒤집기 {
    /*
     * 문제 분석 //
     * <입력>
     * - 첫행 : 숫자 N
     * - 이후 N개 : 스페이스로 구분된 단어들
     *
     * <풀이>
     * - StringTokenizer를 이용하여 공백으로 어절 구분
     * - 각각의 어절을 스택에 넣음
     * - 출력 규칙대로 하나씩 꺼낸다
     *
     * <출력>
     * - "Case #i :" + 스택에서 꺼낸 어절(역순 출력)
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int total = Integer.parseInt(br.readLine());

        for (int i = 0; i < total; i++) {
            Stack<String> stack = new Stack<>();
            st = new StringTokenizer(br.readLine(), " ");
            int countTokens = st.countTokens();
            while (st.hasMoreTokens()){
                stack.push(st.nextToken());
            }
            bw.write("Case #" + (i + 1) + ": ");
            while (!stack.isEmpty()){
                bw.write(stack.pop() + " ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
