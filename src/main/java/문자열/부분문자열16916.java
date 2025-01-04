package 문자열;

import java.io.*;
/*
* contains로 풀었더니 시간초과가 떴다.
* KMP 알고리즘을 공부해서 다시 풀어 볼 것.
* */
public class 부분문자열16916 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String part = br.readLine();
        if(word.contains(part)){
            bw.write("1");
        }else{
            bw.write("0");
        }
        bw.flush();
        bw.close();
    }
}
