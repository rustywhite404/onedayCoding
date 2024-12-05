package hh99_4week.basic;

import java.io.*;
import java.util.StringTokenizer;

public class 바닥장식1388 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        Character[][] list = new Character[w][h];
        for (int i = 0; i < w; i++) {
            String line = br.readLine();
            for (int j = 0; j < h; j++) {
                list[i][j] = line.charAt(j);
            }
        }

        int count = 0;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {

                if (list[i][j].equals('-')) { // '-' 모양 판자라면
                    if (j<h-1 && list[i][j] == list[i][j + 1]) { //옆에 있는 판자와 모양이 같은지 확인, 같다면 같은 판자
                        continue;
                    }
                    //같지 않다면 판자 끝
                    count++;

                }else{ // '|' 모양 판자라면
                    if (i<w-1 && list[i][j] == list[i+1][j]) { //아래에 있는 판자와 모양이 같은지 확인, 같다면
                        continue;
                    }
                    //같지 않다면 판자 끝
                    count++;
                }
            }
        }
        bw.write(count+" ");
        bw.flush();
        bw.close();
    }
}
