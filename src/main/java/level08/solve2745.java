package level08;

import java.io.*;
import java.util.StringTokenizer;

public class solve2745 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        String word = st.nextToken();
        int num = Integer.parseInt(st.nextToken());
        int result = Integer.parseInt(word,num);
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
