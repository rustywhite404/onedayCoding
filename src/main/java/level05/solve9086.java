package level05;

import java.io.*;

public class solve9086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());

        for(int i=1;i<=total;i++){
            String word = br.readLine();
            bw.write(word.charAt(0));
            bw.write(word.charAt(word.length()-1));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
