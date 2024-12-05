package hh99_4week.basic;

import java.io.*;
import java.util.StringTokenizer;

public class 상근이의여행9372 {
    /*
    * 각 경로 별 소요시간이 주어지지 않았기 때문에 최소 간선의 수만 구하면 됨.
    * 최소 간선의 수는 항상 N-1임.
    * 문제 조건이 조금 함정문제(?) 같았다.
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());

        for(int i=0; i<total;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nation = Integer.parseInt(st.nextToken()); //국가의 수
            int flight = Integer.parseInt(st.nextToken()); //비행기의 수

            for(int j=0;j<flight;j++){
                st = new StringTokenizer(br.readLine());
                continue;
            }
            //국가간의 가장 적은 이동거리는 항상 국가의 수 - 1이다.
            bw.write(nation-1+" ");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
