package hh99_1week.basic;

import java.io.*;

public class solve2445_re {
    public static void main(String[] args) throws IOException {
        // 1. 숫자를 입력받고, 출력 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int starList = 2*num;

        // 2-1. 별 찍기(윗부분)
        for(int i=1; i<=num;i++){

            for(int j=0;j<i;j++){
                bw.write("*");
            }
            //공백이 8,6,4,2개 찍혀야 함
            for(int k=1;k<=2*(num-i);k++){
                bw.write(" ");
            }
            for(int l=0;l<i;l++){
                bw.write("*");
            }
            bw.newLine();
        }
        // 2-2. 별 찍기(아랫부분)
        for(int i=num-1;i>0;i--){
            for(int j=i;j>0;j--){
                bw.write("*");
            }
            // i는 4, 3, 2, 1이 됨
            // 공백이 2, 4, 6, 8개 찍혀야 함
            for(int k=1;k<=(num-i)*2;k++){
                bw.write(" ");
            }

            for(int l=i;l>0;l--){
                bw.write("*");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
