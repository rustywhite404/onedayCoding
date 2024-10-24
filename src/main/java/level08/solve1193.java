package level08;

import java.io.*;
import java.util.StringTokenizer;

public class solve1193 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        // 1  2  4  7
        // 3  5  8
        // 6  9
        // 10
        // 대각선의 총 개수 = 1,2,3,4...
        int total = 1; //지금까지 지나온 대각선의 끝 숫자
        int sum = 1; // 대각선 번호
        while(total<num){
            sum++;
            total += sum;

        }

        int position = num - (total-sum); //현재 대각선에서 num의 위치
        int numerator, denominator;
        //현재 대각선이 짝수면 => 분자가 늘어나고 분모가 줄어듦
        if(sum%2==0){
            numerator = position;
            denominator = sum-position+1;
        }else{
            //홀수 대각선 => 분자가 줄어들고 분모가 늘어남
            numerator = sum-position+1;
            denominator = position;
        }
        bw.write(numerator+"/"+denominator);
        bw.flush();
        bw.close();
    }
}
