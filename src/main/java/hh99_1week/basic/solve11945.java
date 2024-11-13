package hh99_1week.basic;

import java.io.*;
import java.util.StringTokenizer;

public class solve11945 {
    public static void main(String[] args) throws IOException {
        //문제 :
        //첫째 줄에는 두 개의 정수 N과 M(0≤N,M≤10)이 주어집니다.
        //둘째 줄부터 N개의 줄에 걸쳐 붕어빵의 모양이 주어집니다.
        //각 행에는 공백을 나타내는 ‘0‘ 또는 붕어빵을 나타내는 ‘1’이 총 M개 주어집니다.
        //입력으로 주어진 붕어빵이 좌우로 뒤집힌 모양을 출력하세요.

        // 1. 출력 준비 및 N 입력받기
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken()); // n개의 행

        //2. reverse() 이용
        for(int i=0;i<n;i++) {
            StringBuffer sb = new StringBuffer(br.readLine());
            String reverse = sb.reverse().toString();
            bw.write(reverse);
            bw.newLine();
        }


        bw.flush();
        bw.close();

    }
}
