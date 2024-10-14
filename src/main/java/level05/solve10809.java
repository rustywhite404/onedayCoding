package level05;

import java.io.*;

public class solve10809 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        char alphabet = 'a';
        for(int i=0;i<26;i++){
            if(word.indexOf(alphabet)==-1){
                bw.write("-1 ");
            }else{
                bw.write(word.indexOf(alphabet)+" ");
            }
            alphabet++;
        }
        bw.flush();
        bw.close();
    }
}
