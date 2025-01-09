package 별찍기;

import java.io.*;

public class 별찍기16_10991 {
    /*
    * 별 n개
    * 1번줄 : n-1개의 공백
    * 2번줄 : n-2개의 공백
    * 3번줄 : n-3개의 공백
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        for(int i=1;i<=total;i++){
            for(int j=0;j<total-i;j++) {
                bw.write(" ");
            }
            for(int k=0;k<i;k++){
                bw.write("* ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
