package 구현;

import java.io.*;
import java.util.*;

public class 윷놀이_2490 {
    /*
     * 도 0 1 1 1
     * 개 0 0 1 1
     * 걸 0 0 0 1
     * 윷 0 0 0 0
     * 모 1 1 1 1
     * */
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int i = 0; i < 3; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 4; j++) {
                sum += Integer.parseInt(st.nextToken());
            }
            switch (sum){
                case 0:
                    bw.write("D");
                    break;
                case 1:
                    bw.write("C");
                    break;
                case 2:
                    bw.write("B");
                    break;
                case 3:
                    bw.write("A");
                    break;
                case 4:
                    bw.write("E");
                    break;
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
