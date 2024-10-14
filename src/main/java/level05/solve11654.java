package level05;

import java.io.*;

public class solve11654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int word = br.readLine().charAt(0);
        bw.write(String.valueOf(word));
        bw.flush();
        bw.close();
    }
}
