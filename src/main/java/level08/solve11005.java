package level08;

import java.io.*;
import java.util.StringTokenizer;

public class solve11005 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int word = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        String result = Integer.toString(word, num);
        bw.write(result.toUpperCase());
        bw.flush();
        bw.close();
    }
}
