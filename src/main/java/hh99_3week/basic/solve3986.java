package hh99_3week.basic;

import java.io.*;
import java.util.Stack;

public class solve3986 {
    /*
     * 문제 해석 :
     * - 첫째줄에 단어의 수 N이 주어진다.
     * - 다음 줄부터 A와 B로만 이루어진 단어가 한 줄에 하나씩 주어진다.
     * - A는 A끼리, B는 B끼리 쌍이 이루어지고 선끼리 교차하지 않는다면 좋은 단어로 카운트 된다.
     * 풀이 전략 :
     * - 들어온 값과 현재 맨 뒤에 있는 값이 동일한 경우 맨 뒤에 있는 값을 꺼낸다
     * - 마지막에 확인했을 때 대기열이 비어있으면 좋은 단어다
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < total; i++) {
            Stack<Character> stack = new Stack<>();
            String word = br.readLine();
            for (int j = 0; j < word.length(); j++) {
                if(!stack.isEmpty()){ //stack이 비어있지 않으면
                    // 들어온 값과 현재 맨 뒤에 있는 값을 비교
                    if(stack.peek().equals(word.charAt(j))){ //같을 경우 맨 뒤에 있는 값을 꺼낸다
                        stack.pop();
                    }else { //다를 경우 현재 값을 입력
                        stack.push(word.charAt(j));
                    }
                }else{ //stack이 비어있으면 바로 값을 집어넣음
                    stack.push(word.charAt(j));
                }
            }
            //문자열 하나가 끝났을 때 스택을 확인, 비어있으면 좋은 단어이므로 count 추가
            if(stack.isEmpty()) count++;
        }
        bw.write(count+" ");
        bw.flush();
        bw.close();
    }
}
