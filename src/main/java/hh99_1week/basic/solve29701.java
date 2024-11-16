package hh99_1week.basic;

import java.io.*;
import java.util.*;

public class solve29701 {
    /*
    * 문제 분석 :
    * - 입력받은 모스부호 문자열을 알파벳으로 변환해서 출력해라.
    *
    * 풀이 전략 :
    * - 모스부호와 알파벳을 키, 값으로 리스트에 저장한다
    * - get으로 해당하는 키의 value를 가져와서 출력한다
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        List<String> words = new ArrayList<>();

        // 모스부호 리스트 만들기
        Map<String, String> mos = new HashMap<>();
        mos.put(".-", "A");
        mos.put("-...", "B");
        mos.put("-.-.", "C");
        mos.put("-..", "D");
        mos.put(".", "E");
        mos.put("..-.", "F");
        mos.put("--.", "G");
        mos.put("....", "H");
        mos.put("..", "I");
        mos.put(".---", "J");
        mos.put("-.-", "K");
        mos.put(".-..", "L");
        mos.put("--", "M");
        mos.put("-.", "N");
        mos.put("---", "O");
        mos.put(".--.", "P");
        mos.put("--.-", "Q");
        mos.put(".-.", "R");
        mos.put("...", "S");
        mos.put("-", "T");
        mos.put("..-", "U");
        mos.put("...-", "V");
        mos.put(".--", "W");
        mos.put("-..-", "X");
        mos.put("-.--", "Y");
        mos.put("--..", "Z");
        mos.put(".----", "1");
        mos.put("..---", "2");
        mos.put("...--", "3");
        mos.put("....-", "4");
        mos.put(".....", "5");
        mos.put("-....", "6");
        mos.put("--...", "7");
        mos.put("---..", "8");
        mos.put("----.", "9");
        mos.put("-----", "0");
        mos.put("--..--", ",");
        mos.put(".-.-.-", ".");
        mos.put("..--..", "?");
        mos.put("---...", ":");
        mos.put("-....-", "-");
        mos.put(".--.-.", "@");

        // 입력받은 모스부호를 배열에 담는다
        for(int i=0;i<total;i++){
            words.add(st.nextToken());
        }
        // 모스부호가 key와 일치하면 alphabet을 반환한다
        for(int j=0;j<words.size();j++){
            bw.write(mos.get(words.get(j)));
        }
        bw.flush();
        bw.close();
    }
}
