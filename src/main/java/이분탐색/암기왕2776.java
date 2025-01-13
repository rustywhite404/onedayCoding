package 이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 암기왕2776 {
    /*
    * 첫 줄에 테스트 케이스 갯수 T
    * 둘째줄 : 수첩1에 적어놓은 정수의 개수 N
    * 셋째줄 : 수첩1에 적힌 정수 N개
    * 넷째줄 : 수첩2에 적힌 정수의 개수 M
    * 다섯째 : 수첩2에 적힌 정수 M개
    *
    * 출력 :
    * 수첩2에 적혀있는 M개의 숫자 순서대로 수첩1에 있으면 1, 없으면 0 출력
    * */

    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int total = Integer.parseInt(br.readLine());
        for(int i=0;i<total;i++){
        int note1Count = Integer.parseInt(br.readLine());
        Set<Integer> note1set = new HashSet<>();
        st = new StringTokenizer(br.readLine()," ");

        for(int j=0;j<note1Count;j++){
            note1set.add(Integer.parseInt(st.nextToken()));
        }

        int note2Count = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");

            for(int j=0;j<note2Count;j++){
                int currentNum = Integer.parseInt(st.nextToken());
                if(note1set.contains(currentNum)){
                    bw.write("1");
                }else{
                    bw.write("0");
                }
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}
