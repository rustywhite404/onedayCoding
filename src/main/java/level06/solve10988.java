package level06;

import java.io.*;
public class solve10988 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        StringBuffer sb = new StringBuffer(word);
        if(word.equals(sb.reverse().toString())){
            bw.write(String.valueOf(1));
        }else{
            bw.write(String.valueOf(0));
        }
        bw.flush();
        bw.close();
    }
}
