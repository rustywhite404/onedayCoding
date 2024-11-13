package hh99_1week.plus;

import java.io.*;
import java.util.StringTokenizer;

public class solve2167 {
    public static void main(String[] args) throws IOException {
        /*
         * 문제 분석 :
         * - 첫째 줄에 배열의 크기 n, m이 주어진다.
         * - 다음 n개의 줄에 m개의 정수 배열이 주어진다.
         * - 그 다음 줄에는 합을 구해야 하는 영역의 개수가 주어진다
         * - 그 다음 줄에는 네 개의 정수 i, j, x, y의 좌표가 주어진다.
         *
         * 풀이 전략 :
         * - 배열의 크기 n, m을 입력받기
         * - 배열 int[n][m]에 값을 넣고 초기화 한다
         * - 합을 구해야 할 영역 갯수 입력받기
         * - 받은 좌표들로 i부터 x까지, j부터 y까지 값을 증가시키며 각 자리의 값을 찾아 더한다
         * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 1. 배열의 크기 n, m을 입력받기
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] list = new int[n][m];

        // 2. 배열 int[n][m]에 값을 넣고 초기화 한다
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 3. 합을 구해야 할 영역 갯수 입력받기
        int count = Integer.parseInt(br.readLine());

        // 4. 받은 좌표들로 i부터 x까지, j부터 y까지 값을 증가시키며 각 자리의 값을 찾아 더한다
        for (int num = 0; num < count; num++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken())-1;
            int j = Integer.parseInt(st.nextToken())-1;
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int sum = 0;

            for (int a = i; a <= x; a++) {
                for (int b = j; b <= y; b++) {
                    sum += list[a][b];
                }
            }
            bw.write(sum+" ");
            bw.newLine();

        }

        bw.flush();
        bw.close();


    }
}
