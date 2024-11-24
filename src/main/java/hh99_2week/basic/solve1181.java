package hh99_2week.basic;

import java.io.*;
import java.util.*;

public class solve1181 {
    /*
    * 문제 분석 :
    * - 첫줄에 단어의 갯수 N 입력
    * - 둘째줄부터 N개의 줄에 입력되는 단어를 정렬한다
    * - 길이가 짧은 것부터
    * - 길이가 같으면 사전순으로
    * - 중복은 제거한다
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        String[] words = new String[total];
        for(int i=0;i<total;i++){
            words[i] = br.readLine();
        }

        //중복 제거
        Set<String> setList = new LinkedHashSet<>(Arrays.asList(words));
        //중복 제거한 데이터를 정렬 준비
        List<String> wordList = new ArrayList<>(setList);

        //길이가 짧은 것부터 오름차순 정렬, 길이가 같으면 사전순
        wordList.sort((s1, s2) -> {
            if (s1.length() != s2.length()) {
                return s1.length() - s2.length();
            }
            return s1.compareTo(s2);
        });


        //출력
        for (String s : wordList) {
            bw.write(s);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
