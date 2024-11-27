package hh99_3week.basic;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class solve27497 {
    /*
     * 문제 해석 :
     * - 각 블록에는 버튼 번호, 문자 1개가 주어진다.
     * - 버튼을 누른 횟수와 문자에 따라 완성된 문자열을 출력.
     * 풀이 전략 :
     * - 앞, 뒤에 모두 추가해야 하므로 데크를 사용해서 구현
     * - 스택으로 가장 최근 블록이 앞에 추가됐으면 0, 뒤에 추가됐으면 1로 표시하여
     * - 3번 버튼에서 어떤 블록을 제거해야 할 지 결정
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int total = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack();
        Deque<String> deque = new ArrayDeque<>();
        for (int i = 0; i < total; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "1":
                    deque.addLast(st.nextToken());
                    stack.push(1);
                    break;
                case "2":
                    deque.addFirst(st.nextToken());
                    stack.push(0);
                    break;
                case "3":
                    if(stack.isEmpty()) continue;
                    if(stack.pop()==0){
                        deque.removeFirst();
                    }else{
                        deque.removeLast();
                    }
            }
        }
        if(deque.isEmpty()){
            bw.write("0");
        }else {
            for (String s : deque) {
                bw.write(s);
            }
        }
        bw.flush();
        bw.close();
    }
}
