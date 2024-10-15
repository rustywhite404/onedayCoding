package level05;

import java.io.*;
import java.util.StringTokenizer;

public class solve2675 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        for(int i=1;i<=total;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int count = Integer.parseInt(st.nextToken());
            String word = st.nextToken();
            for(int k=0;k<word.length();k++){
                for(int j=0;j<count;j++){
                    bw.write(word.charAt(k));
                }
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
