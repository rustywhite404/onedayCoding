package 문자열;

import java.io.*;

public class 단어길이재기2743 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine();

        bw.write(word.length()+" ");
        bw.flush();
        bw.close();

    }
}
