package level07;

import java.io.*;
import java.util.StringTokenizer;

public class solve10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[][] words = new char[5][15];
        int num=0;
        //배열 초기화
        for(int i=0;i<5;i++){
            for(int j=0;j<15;j++){
                words[i][j]='\0';
            }
        }
        //단어 입력받기
        for(int i=0;i<5;i++){
            String word = br.readLine();
            for(int j=0;j<word.length();j++){
                words[i][j] = word.charAt(j);
            }
        }
        for(int k=0;k<15;k++){
            for(int l=0;l<5;l++){
                if(words[l][k]!='\0'){
                    bw.write(String.valueOf(words[l][k]));
                }
            }
        }
        bw.flush();
        bw.close();

    }
}
