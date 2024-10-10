package level03;

import java.io.*;
import java.util.StringTokenizer;

public class solve10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        do{
            bw.write(String.valueOf(a+b));
            bw.newLine();
            st = new StringTokenizer(br.readLine()," ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
        }while(a!=0 || b!=0);
        bw.flush();
        bw.close();
    }
}
