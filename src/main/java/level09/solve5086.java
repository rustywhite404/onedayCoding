package level09;

import java.io.*;
import java.util.StringTokenizer;

public class solve5086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        while (!(a==0)&&!(b==0)){
            String word = "neither";
            if(a%b==0){
                word = "multiple";
            }else if(b%a==0){
                word = "factor";
            }

            bw.write(word);
            bw.newLine();
            st = new StringTokenizer(br.readLine()," ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
        }
        bw.flush();
        bw.close();

    }
}
