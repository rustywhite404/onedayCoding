package hh99_1week.plus;

import java.io.*;
import java.util.Arrays;

public class solve4779 {
    /*
     * 문제 분석 :
     * -가 3의 n승개 있는 문자열 A에서 시작한다.
     * 문자열 A를 3등분 한 뒤, 가운데 문자열을 공백으로 바꾼다. 이렇게 하면 선(문자열)2개가 남는다.
     * 남은 문자열을 각각 3등분 하고, 가운데 문자열을 공백으로 바꾼다.
     * 이 과정을 모든 선의 길이가 1이 될때까지 반복한다.
     *
     * 풀이 전략 :
     * - 입력받은 숫자 n으로, 3의 n승 문자열을 만든다.
     * - 글자수/3 으로 3등분 할 문자열의 글자수를 확인한 후 가운데 문자열을 공백으로 치환한다.
     * - 왼쪽과 오른쪽 부분에 대해 재귀 반복을 각각 실행.
     * - 문자열의 길이가 2 이하이면(3등분 할 수 없으면) 종료하고 출력한다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word;
        while ((word = br.readLine())!=null){
            int n = Integer.parseInt(word);
            int start = (int) Math.pow(3, n);
            char[] strlist = new char[start];
            Arrays.fill(strlist, '-');

            // 칸토어 만들기
            createKanto(strlist, 0, start);

            for (char s : strlist) {
                bw.write(s);
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    private static void createKanto(char[] strlist, int start, int length) {
        if (length < 3) return; //문자열의 길이가 2 이하이면(3등분 할 수 없으면) 종료
        int part = length / 3;

        //가운데 부분 공백 처리
        for (int i = start + part; i < start + 2 * part; i++) {
            strlist[i] = ' ';
        }
        //왼쪽 문자열 처리 
        createKanto(strlist, start, part);
        //오른쪽 문자열 처리
        createKanto(strlist, start + 2 * part, part);

    }
}
