package 그리디;

import java.io.*;

public class 수들의합1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long num = Long.parseLong(br.readLine());

        long current = 1;
        while (true) {
            if(num - current > current) {
                num -= current;
                current++;
            }else {
                break;
            }
        }
        bw.write(current + "");
        bw.flush();
        bw.close();
    }
}
