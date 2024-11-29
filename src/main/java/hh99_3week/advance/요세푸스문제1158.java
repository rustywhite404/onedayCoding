package hh99_3week.advance;

import java.io.*;
import java.util.*;

public class 요세푸스문제1158 {
    /*
     * 입력 : 요세푸스 순열의 길이 N, 제거할 순번 K가 주어진다
     *
     * 연산 :
     * - 1. 큐에 순열의 길이 만큼의 값을 쌓는다
     * - 2. 큐에서 값을 빼서 바로 다시 쌓기를 반복한다(큐가 빌 때까지 반복)
     * - 3. 반복의 3번째에서 값을 꺼내 결과값 배열에 넣는다.
     *
     * 출력 : <요세푸스 순열>의 형태로 출력한다 ex) <3,6,2,7,5,1,4>
     *
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Queue<Integer> list = new LinkedList<>();
        int total = Integer.parseInt(st.nextToken()); //전체 수열의 길이
        int pick = Integer.parseInt(st.nextToken()); //제거할 순번
        int count = 0;
        //수열의 길이만큼 큐에 값을 쌓는다
        for (int i = 1; i <= total; i++) {
            list.add(i);
        }


        bw.write("<");
        while (!list.isEmpty()) {
            count++;
            // pick번째 마다 값을 꺼내서 결과값 배열에 넣는다. 나머지 순서에서는 큐에서 값을 빼서 바로 다시 쌓기를 반복한다
            if (count % pick == 0) {
                bw.write(String.valueOf(list.poll()));
                if(!list.isEmpty()){ //마지막 숫자가 아니면 , 추가
                    bw.write(", ");
                }
            } else {
                list.add(list.poll());
            }

        }
        bw.write(">");
        bw.flush();
        bw.close();
    }
}
