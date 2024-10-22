package level08;

import java.io.*;

public class solve2903 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 점이 (2n+1)의 제곱으로 늘어남
        int pointCount = (int) Math.pow(2, n) + 1;
        int result = pointCount * pointCount;
        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
    }
}
