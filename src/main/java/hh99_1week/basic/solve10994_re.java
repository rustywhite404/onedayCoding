package hh99_1week.basic;

import java.io.*;

public class solve10994_re {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //n이 1일때 가로 1
        //n이 2일때 가로 5
        //n이 3일때 가로 9
        //가로세로 = n*4-3
        //제일 바깥에 int[n*4-3][n*4-3]의 사각형을 만든다
        //사각형에 전부 공백 넣기
        //테두리 상하, 테두리 좌우에 별 찍기
        //안쪽에 작은
        int num = Integer.parseInt(br.readLine());
        int size = num * 4 - 3;
        String[][] starArea = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                starArea[i][j] = " ";
            }
        }

        //별찍기
        createdStar(starArea, 0, size);
        for (int i = 0; i < size; i++) {
            bw.write(String.join("", starArea[i]));
            bw.newLine();
        }
        bw.flush();
        bw.close();

    }

    private static void createdStar(String[][] starArea, int start, int size) {
        if (size < 1) {
            return;
        }
        int end = start + size - 1;

        //테두리 상하에 별 찍기
        for (int i = start; i <= end; i++) {
            starArea[start][i] = "*";
            starArea[end][i] = "*";
            //좌우
            starArea[i][start] = "*";
            starArea[i][end] = "*";
        }
        createdStar(starArea, start + 2, size - 4);

    }

}
