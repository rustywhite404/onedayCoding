package BFS;

import java.io.*;
import java.util.StringTokenizer;

public class NewTime26876 {

    /*
    * 시간이 증가하는 건 분에 영향이 없지만, 분이 증가하면 시간에 영향이 생김
    * 60분이 넘어가면 1시간 증가
    * 따라서 분이 다른 경우 분을 먼저 증가시키고, 분이 같은 경우에만 시간을 증가시킴
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(),":");
        int wrongH = Integer.parseInt(st.nextToken());
        int wrongM = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(),":");
        int currentH = Integer.parseInt(st.nextToken());
        int currentM = Integer.parseInt(st.nextToken());
        int buttonCount = 0;

        //분 증가시킴
        while (currentM!=wrongM){
            wrongM++;
            buttonCount++;
            if(wrongM==60){
                wrongM=0;
                wrongH++;
            }
        }
        if(wrongH==24){
            wrongH=0;
        }
        //시간 증가시킴
        while (currentH!=wrongH){
            wrongH++;
            buttonCount++;
            if(wrongH==24){
                wrongH=0;
            }
        }

        bw.write(buttonCount+" ");
        bw.flush();
        bw.close();


    }
}
