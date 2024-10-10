package level03;

import java.io.*;
import java.util.StringTokenizer;

public class solve11022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        for(int i=1;i<=count;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf("Case #"+i+": "+a+" + "+b+" = "+(a+b)));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
