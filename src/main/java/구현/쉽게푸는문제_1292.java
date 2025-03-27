package 구현;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 쉽게푸는문제_1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= b; i++) {
            for (int j = 1; j <= i; j++) {
                list.add(i);
            }
        }
        int sum = 0;
        for (int i = a; i <= b; i++) {
            sum += list.get(i-1);
        }
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
