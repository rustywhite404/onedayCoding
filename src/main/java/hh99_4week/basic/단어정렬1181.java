package hh99_4week.basic;

import java.io.*;
import java.util.*;

public class 단어정렬1181 {
    /*
     * 입력 :
     * - N개의 단어 수
     * - N개의 단어
     *
     * 연산 :
     * - 우선 Set에 넣어서 중복을 제거하고
     * - 리스트에 옮겨서 길이가 짧은 순으로 sort
     * - 길이가 같으면 사전순 compareTo 정렬
     *
     * 출력 :
     * - 길이가 짧은 것부터, 길이가 같으면 사전순으로 정렬, 중복은 제거
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < total; i++) {
            set.add(br.readLine()); //Set에 단어들을 넣어서 중복 제거
        }

        List<String> list = new ArrayList<>(set); //Set을 List로 변환
        Collections.sort(list,(o1, o2) -> {
            if(o1.length()!=o2.length()){ //둘의 길이가 다르면
                return o1.length() - o2.length(); //오름차순 정렬
            }
            //길이가 같으면 사전순 정렬
            return o1.compareTo(o2);
        });

        for (String s : list) {
            bw.write(s);
            bw.newLine();
        }
        bw.flush();
        bw.close();


    }
}
