package level06;

import java.io.*;
import java.util.StringTokenizer;

public class solve2444 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int count = 2*num-1;
        int num2 = num;
        int num5 = 1;
        for(int i=1;i<=count;i++){ //9번 반복
            int num3 = 2*i-1;
            int num4 = 2*i-count;
            if(num3<=count){
                for(int j=1;j<num2;j++){ //공백 반복
                    bw.write(" ");
                }
                num2--;
                for(int k=1;k<=num3;k++) { //별 1개부터 2개씩 늘어나야함
                    bw.write("*");
                }
                bw.newLine();
            }else{
                //num3이 count보다 커지면
                for(int j=0;j<num5;j++){ //공백 반복
                    bw.write(" ");
                }
                num5++;
                for(int k=count-num4;k>=0;k--){
                    bw.write("*");
                    num4 += 1;
                }
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }
}
