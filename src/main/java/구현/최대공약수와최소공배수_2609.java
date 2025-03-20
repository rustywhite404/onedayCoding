package 구현;

import java.io.*;
import java.util.StringTokenizer;

public class 최대공약수와최소공배수_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int max = 1;
        int cur = 2;
        while (cur <= a && cur <= b) {
            if (a % cur == 0 && b % cur == 0) {
                max = cur;
            }
            cur++;
        }
        bw.write(max + "\n");

        cur = 1;
        while (cur < 10000) {
            int temp = a * cur;
            if (temp % b == 0) {
                bw.write(temp + "\n");
                break;
            }
            cur++;
        }

        bw.flush();
        bw.close();
    }

}
