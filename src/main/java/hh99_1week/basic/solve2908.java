package hh99_1week.basic;

import java.io.*;
import java.util.StringTokenizer;

public class solve2908 {
    /*
    - 문제 분석 :
    - 123과 456이라는 입력값을 321과 654로 받아들인 후 크기를 비교해서 리턴한다

    - 풀이 전략 :
    - 입력값을 공백 기준으로 잘라낸 후 reverse로 뒤집고 비교해서 큰 값을 리턴해보자
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb1 = new StringBuilder(st.nextToken());
        StringBuilder sb2 = new StringBuilder(st.nextToken());
        int a = Integer.parseInt(sb1.reverse().toString());
        int b = Integer.parseInt(sb2.reverse().toString());

        bw.write(String.valueOf((a>b?a:b)));
        bw.flush();
        bw.close();

    }
}
