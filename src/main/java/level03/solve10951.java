package level03;

import java.io.*;
import java.util.StringTokenizer;

public class solve10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word;
        while ((word = br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(word," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(a+b));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
