package level08;

import java.io.*;
import java.util.StringTokenizer;

public class solve2869 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int day = Integer.parseInt(st.nextToken());
        int night = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int current = 0;
        int count = 0;
        // 값은 맞는데 시간초과가 떠서 다른 방법을 찾기로 함
        //        while(current<=height){
//            count++;
//            current += day;
//            if(current>=height){
//                break;
//            }
//            current -= night;
//        }
        current = day-night; //하루에 올라가는 높이
        height -= night; //마지막 날에는 안 미끄러지므로 한번 뺌
        count = height/current;
        if(height%current!=0){
            bw.write(String.valueOf(count+1));
        }else{
            bw.write(String.valueOf(count));
        }
        bw.flush();
        bw.close();

    }
}
