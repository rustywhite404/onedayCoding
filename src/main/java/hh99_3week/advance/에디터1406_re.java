package hh99_3week.advance;

import java.io.*;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

//LinkedList로 풀면 시간초과가 떠서 Stack 두개를 이용한 구현 방법을 사용.
public class 에디터1406_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine();
        int n = Integer.parseInt(br.readLine());

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        //초기 문자열을 왼쪽 스택에 삽입
        for (Character c : word.toCharArray()) {
            leftStack.push(c);
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            switch(st.nextToken()){
                case "L": //커서를 왼쪽으로 이동
                    if(!leftStack.isEmpty()){
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case "D": //커서를 오른쪽으로 이동
                    if(!rightStack.isEmpty()){
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case "B": //커서 왼쪽 문자 삭제
                    if(!leftStack.isEmpty()){
                        leftStack.pop();
                    }
                    break;
                case "P": //커서 위치에 문자 추가
                    leftStack.push(st.nextToken().charAt(0));
                    break;
            }

        }
        //최종 결과 조합
        while (!leftStack.isEmpty()){
            rightStack.push(leftStack.pop());
        }
        while (!rightStack.isEmpty()){
            bw.write(rightStack.pop());
        }

        bw.flush();
        bw.close();
    }
}
