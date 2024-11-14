package hh99_1week.basic;

import java.io.*;
import java.util.StringTokenizer;

public class solve9184 {
    /*
     * 문제 분석 :
     * - 입력된 a,b,c에 대해 재귀함수 w(a,b,c)를 작성한다.
     * - 계속해서 다음 줄에 세 정수가 주어지며, 입력이 끝날 때는 -1, -1, -1로 종료한다.
     * - 출력 형식은 w(a,b,c) = 결과값
     *
     * 풀이 전략 :
     * - 재귀함수 구현법 자체는 문제에 나와있다. 메모이제이션으로 시간복잡도를 줄이는 게 관건
     * - 충분한 크기의 메모이제이션 배열을 설정한다
     * - 각 조건에 맞추어 w(a,b,c)를 계산하되 이미 계산한 적 있다면 메모이제이션에 저장된 값을 그대로 리턴한다
     * */


    //memoization 배열을 선언, 배열의 크기는 최대로 들어올 값보다 충분히 커야 한다
    static int[][][] memo = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            bw.write("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    public static int w(int a, int b, int c) {

        // a,b,c 중 하나라도 0 이하일 경우 1을 반환
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        // a,b,c가 20 이상이면 w(20,20,20)값을 반환
        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        // 이미 계산된 값이 있다면 그 값을 반환
        if (memo[a][b][c] != 0) {
            return memo[a][b][c];
        }

        // 게산된 값이 없을 경우 :
        // a<b<c일 경우
        if (a < b && b < c) {
            memo[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else { //나머지일 경우
            memo[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }

        return memo[a][b][c];

    }
}
