package hh99_3week.basic;

import java.io.*;
import java.util.Stack;

public class 막대기 {
    /*
     * 문제 분석 :
     * - 막대기 N개가 있고, 각각의 높이가 다르다(같은 것도 존재 가능)
     * - 오른쪽에서 보았을 때 몇개가 보이는지 카운트
     *
     * 풀이 전략 :
     * - 순서대로 막대기를 스택에 넣고, 하나씩 꺼낸다
     * - 방금 꺼낸 막대기보다 뒤에 꺼낸 막대기가 더 크면 카운트한다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        int max = 0; //제일 높은 막대기
        // 스택에 막대기들을 입력
        for (int i = 0; i < total; i++) {
            stack.push(Integer.parseInt(br.readLine()));
        }


        for(int j=0;j<total;j++){
            int current = stack.pop();
            if(current>max){
                max = current;
                count++;
            }
        }
        bw.write(count+" ");
        bw.flush();
        bw.close();
    }
}
