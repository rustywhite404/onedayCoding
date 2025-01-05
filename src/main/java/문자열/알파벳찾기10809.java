package 문자열;
import java.io.*;

public class 알파벳찾기10809 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine();
        for(int i=0;i<26;i++){
            int current = 'a'+i;
            bw.write(word.indexOf(current)+" ");

        }
        bw.flush();
        bw.close();
    }

}
