package 완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 날짜계산1476 {
    /*
     * 지구 E(1~15) , 태양 S(1~28) , 달 M(1~19)
     * 15년 = 15 15 15
     * 16년 = 1 16 16
     *
     * */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int nowE = 0;
        int nowS = 0;
        int nowM = 0;
        int year = 0;


        while (!(E == nowE && S == nowS && M == nowM)) {
            year++;
            if(nowE==15){
                nowE = 0;
            }
            nowE++;
            if(nowS==28) {
                nowS = 0;
            }
            nowS++;
            if(nowM==19) {
                nowM = 0;
            }
            nowM++;


        }
        bw.write(year+"");
        bw.flush();
        bw.close();
    }
}
