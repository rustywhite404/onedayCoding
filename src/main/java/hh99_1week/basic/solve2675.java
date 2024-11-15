package hh99_1week.basic;

import java.io.*;
import java.util.StringTokenizer;

public class solve2675 {
    /*
    * 문제 분석 :
    * - 첫쨋줄에 테스트 케이스의 갯수가 주어진다
    * - 둘쨋줄부터 입력받은 문자열을 n번 반복한다.
    *
    * 풀이 전략 :
    * - 첫쨋줄에 받은 숫자만큼 반복문
    * - StringTokenizor로 횟수와 문자열을 분리한다
    * - 횟수만큼 문자열을 반복하고 출력
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int total = Integer.parseInt(br.readLine()); //전체 테스트 케이스의 수

        for(int i=0;i<total;i++){
           st = new StringTokenizer(br.readLine()," ");
           int count = Integer.parseInt(st.nextToken()); //입력값에서 분리한 반복횟수
           String word = st.nextToken(); //입력값에서 분리한 문자열
           String repeatWord = ""; //새로 만들 반복문자열을 저장

           for(int j=0;j<word.length();j++){
               repeatWord += String.valueOf(word.charAt(j)).repeat(count); //word에서 각 자리의 단어를 count 횟수만큼 반복한다
           }

            bw.write(repeatWord);
            bw.newLine();
        }
        bw.flush();
        bw.close();

    }
}
