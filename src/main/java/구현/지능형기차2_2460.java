package 구현;

import java.io.*;
import java.util.StringTokenizer;

public class 지능형기차2_2460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int max = 0;
        int count = 0;
        for(int i=0;i<10;i++){
            st = new StringTokenizer(br.readLine());
            int sending = Integer.parseInt(st.nextToken());
            int pickup = Integer.parseInt(st.nextToken());
            count -= sending;
            count += pickup;
            if(count > max){
                max = count;
            }
        }
        bw.write(max+"\n");
        bw.flush();
        bw.close();
    }
}
