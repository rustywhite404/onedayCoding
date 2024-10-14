package level05;

import java.io.*;

public class solve27866 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int num = Integer.parseInt(br.readLine());
        bw.write(word.charAt(num-1));
        bw.flush();
        bw.close();
    }
}
