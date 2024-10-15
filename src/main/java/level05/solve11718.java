package level05;

import java.io.*;
import java.util.StringTokenizer;

public class solve11718 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp;

        while ((temp=br.readLine())!=null){
            bw.write(temp);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
