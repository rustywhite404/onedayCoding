package level03;

import java.io.*;
import java.util.StringTokenizer;

public class solve11021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int count = Integer.parseInt(br.readLine());
        int a,b;
        for(int i=1;i<=count;i++){
            st = new StringTokenizer(br.readLine()," ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf("Case #"+i+": "+(a+b)));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
