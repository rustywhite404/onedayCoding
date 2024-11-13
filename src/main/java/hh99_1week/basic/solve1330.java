package hh99_1week.basic;

import java.io.*;
import java.util.StringTokenizer;

public class solve1330 {
    public static void main(String[] args) throws IOException {
        // 1. A와 B를 입력받아 변수에 담는다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 2. A가 B보다 크면 >, 작으면 <, 같으면 ==를 출력한다.
        if(a>b){
            bw.write(">");
        } else if (a<b) {
            bw.write("<");
        }else {
            bw.write("==");
        }
        bw.flush();
        bw.close();
    }
}
