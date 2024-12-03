package hh99_3week.advance;

import java.io.*;
import java.util.*;

public class 단어정렬1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());

        //일단 단어 중복을 제거해서 저장한다(Set)
        Set<String> word = new LinkedHashSet<>();
        for(int i=0;i<total;i++){
            word.add(br.readLine());
        }

        //중복을 제거한 데이터를 정렬
        List<String> wordList = new ArrayList<>(word);
        wordList.sort((a, b)->{
            if(a.length()!=b.length()){ //둘의 길이가 다르면
                return a.length()-b.length(); //오름차순으로 정렬
            }
            return a.compareTo(b); //길이가 같으면 사전순 정렬
        });

        for (String s : wordList) {
            bw.write(s);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
