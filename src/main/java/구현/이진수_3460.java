package 구현;

import java.io.*;

public class 이진수_3460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        for(int i = 0; i < total; i++) {
            int num = Integer.parseInt(br.readLine());
            String s = Integer.toBinaryString(num);
            StringBuffer sb = new StringBuffer(s);
            String reverse = sb.reverse().toString();
            for(int j = 0; j < reverse.length(); j++) {
                if(reverse.charAt(j) == '1') {
                    bw.write(j+" ");
                }
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
