package 구현;

import java.io.*;

public class 피보나치수5_10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int[] result = new int[num];

        if(num == 1 ){
            bw.write(1+"");
        }else if(num == 0 ){
            bw.write(0+"");
        }else {
            result[0] = 1;
            result[1] = 1;

            for (int i = 2; i < num; i++) {
                result[i] = result[i - 2] + result[i - 1];
            }
            bw.write(String.valueOf(result[num - 1]));
        }

        bw.flush();
        bw.close();
    }
}
