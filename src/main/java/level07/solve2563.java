package level07;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class solve2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[][] field = new boolean[100][100];
        int sum = 0;
        int total = Integer.parseInt(br.readLine());
        for(int h=0;h<total;h++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int i = x; i < x+10; i++) {
                for (int j = y; j < y+10; j++) {
                    if (!field[i][j]) {
                        field[i][j] = true;
                        sum++;
                    }
                }
            }
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();

    }
}
