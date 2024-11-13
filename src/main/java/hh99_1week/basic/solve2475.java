package hh99_1week.basic;

import java.io.*;
import java.util.StringTokenizer;

public class solve2475 {
    public static void main(String[] args) throws IOException {
        // 1. a~e를 입력받아 변수에 담는다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int num = 0;
        int sum = 0;

        // 2. 각 숫자를 제곱한다
        for(int i = 0; i < 5; i++){
            num = Integer.parseInt(st.nextToken());
            num *= num;
            sum += num;
        }

        // 4. sum을 10으로 나눈 나머지 = 검증수
        int result = sum%10;

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
