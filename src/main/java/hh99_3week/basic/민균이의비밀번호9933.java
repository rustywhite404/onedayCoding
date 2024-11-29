package hh99_3week.basic;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class 민균이의비밀번호9933 {
    /*
     * 입력 :
     * - 단어의 수 N
     * - 단어가 한줄에 하나씩 주어지고, 항상 홀수이다.
     *
     * 연산 :
     * - 단어 리스트 중에서 입력받은 문자열을 거꾸로 뒤집은 문자열과 일치하는 게 있는지 확인한다.
     * - 일치하는 문자열이 있다면 비밀번호임.
     *
     * 출력 :
     * - 비밀번호의 길이와 가운데 글자를 출력하는 프로그램을 작성하시오
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        Map<String, Integer> wordList = new HashMap<>();
        //Map에 데이터를 입력한다
        for (int i = 0; i < total; i++) {

            String word = br.readLine();
            wordList.put(word, word.length());
        }

        //해시맵에서 꺼내온 key를 뒤집었을 때, 기존 해시테이블에 일치하는 문자열이 있는지 확인

        for (String s : wordList.keySet()) {
            StringBuffer sb = new StringBuffer(s);
            if(wordList.containsKey(sb.reverse().toString())){
                //문자열 가운데 문자를 계산
                int centerIndex = s.length()/2;

                bw.write(s.length()+" "+s.substring(centerIndex, centerIndex+1));
                break;
            };
        }
        bw.flush();
        bw.close();

    }
}
