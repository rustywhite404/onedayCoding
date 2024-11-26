package hh99_2week.basic;

import java.io.*;
import java.util.Stack;

public class solve9012 {
    /*
     * 문제 해석 :
     * 괄호 문자열의 (와 )의 짝이 맞는지 판단하여 결과를 YES와 NO로 입력한다.
     * 풀이 전략 :
     * 스택에 문자열을 하나씩 떼어서 넣는다.
     * (가 들어왔을 때 push한다
     * )가 입력되면 (를 pop 한다
     * 스택이 비어있는데 )가 입력되면 false를 리턴
     * 정상적으로 완료되었으면 true를 리턴
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        boolean vps;

        for (int i = 0; i < total; i++) {
            vps = true;
            String word = br.readLine();
            Stack<Character> st = new Stack<>();

            //문자열을 순회하며 처리
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j); //현재 문자 가져오기

                if (c=='(') {
                    st.push(c); // '('는 스택에 추가
                } else if (c==')') {
                    if (st.isEmpty()) {
                        vps = false; //스택이 비어있는데 ')'가 들어오면 VPS 아님
                        break;
                    }
                    st.pop(); // ')'가 들어오면 스택에서 (를 꺼냄(짝맞추기)
                }
            }

            // 처리가 모두 끝났을 때 스택이 비어있지 않다면 VPS 아님
            if(!st.isEmpty()){
                vps = false;
            }

            // VPS 여부 확인
            if (vps) {
                bw.write("YES");
                bw.newLine();
            } else {
                bw.write("NO");
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();

    }
}
