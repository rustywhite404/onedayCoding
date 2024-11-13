package hh99_1week.basic;

import java.io.*;
import java.util.StringTokenizer;

public class solve11945_s2 {
    public static void main(String[] args) throws IOException {
        //문제 :
        //첫째 줄에는 두 개의 정수 N과 M(0≤N,M≤10)이 주어집니다.
        //둘째 줄부터 N개의 줄에 걸쳐 붕어빵의 모양이 주어집니다.
        //각 행에는 공백을 나타내는 ‘0‘ 또는 붕어빵을 나타내는 ‘1’이 총 M개 주어집니다.
        //입력으로 주어진 붕어빵이 좌우로 뒤집힌 모양을 출력하세요.

        // 1. 출력 준비 및 N 입력받기
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // n개의 행
        int m = Integer.parseInt(st.nextToken()); // m개의 열

        //2-1-1. int[n][m] 배열을 초기화
        int[][] list = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                list[i][j] = line.charAt(j) - '0'; //0을 빼서 char를 int로 변환
            }
        }

        //2-1-2. 배열 좌우 뒤집기
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j > 0; j--) {
                bw.write(list[i][j] + "");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
