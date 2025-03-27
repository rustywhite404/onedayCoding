package 브루트포스;

import java.io.*;

public class 사탕게임_3085 {

    static int N; // 보드 크기
    static char[][] board; //사탕 보드

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        //보드 입력받기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int answer = 0; //최댓값 저장

        //모든 칸에 대해 오른쪽, 아래쪽 사탕과 바꿔보기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                //오른쪽 사탕과 교환
                if (j + 1 < N) {
                    swap(i, j, i, j + 1); //사탕 위치 바꾸기
                    int count = countMaxCandy(); //최대 연속 사탕 개수 세기
                    answer = Math.max(answer, count); //최댓값 갱신
                    swap(i, j, i, j + 1);
                }

                //아래쪽 사탕과 교환
                if (i + 1 < N) {
                    swap(i, j, i + 1, j);
                    int count = countMaxCandy();
                    answer = Math.max(answer, count);
                    swap(i, j, i + 1, j);
                }
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    //두 사탕의 위치 바꾸기
    static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    // 현재 보드에서 제일 긴 연속된 사탕 개수 세기
    static int countMaxCandy() {
        int maxCount = 0;

        //모든 행을 검사
        for (int i = 0; i < N; i++) {
            int count = 1; //같은 색 사탕 개수 세기 시작
            for (int j = 1; j < N; j++) {
                if (board[i][j] == board[i][j - 1]) {
                    count++; //이전 사탕과 색이 같으면 개수 증가
                } else {
                    count = 1; //다르면 다시 1로 초기화
                }
                maxCount = Math.max(maxCount, count); //최댓값 갱신
            }
        }

        //모든 열을 검사
        for (int j = 0; j < N; j++) {
            int count = 1;
            for (int i = 1; i < N; i++) {
                if (board[i][j] == board[i - 1][j]) {
                    count++;
                }else {
                    count = 1;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }

}
