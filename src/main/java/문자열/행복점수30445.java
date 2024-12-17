package 문자열;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class 행복점수30445 {
    /*
    * - 입력받은 문자열에서 공백을 제거한다
    * - 글자가 HAPPY에 포함되면 행복한 글자이고 SAD에 포함되면 우울한 글자이다.
    * - 행복한 글자면 행복점수 PH를 1 증가
    * - 우울한 글자면 우울점수 PG를 1 증가
    * - 행복지수 H = PH/(PH+PG)
    * - 행복점수와 우울점수가 모두 0이면 행복지수는 0.5
    * - 행복지수는 백분율로 출력하고, 소수점 이하 두 자리까지 반올림하여 출력한다.
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String words = br.readLine();
        //문자열에서 공백 제거
        words = words.replaceAll(" ","");

        Set<Character> happySet = new HashSet<>();
        Set<Character> sadSet = new HashSet<>();

        // "HAPPY"와 "SAD" 문자열을 Set으로 변환
        for (char ch : "HAPPY".toCharArray()) {
            happySet.add(ch);
        }
        for (char ch : "SAD".toCharArray()) {
            sadSet.add(ch);
        }

        //문자열을 charArray로 변경
        char[] charArr = words.toCharArray();

        double PH = 0;
        double PG = 0;

        for (char c : charArr) {
            if(happySet.contains(c)){
                PH++;
            }
            if(sadSet.contains(c)){
                PG++;
            }
        }

        double HappyScore = 0.0;
        if(PH==0 && PG==0){
            HappyScore = 0.5;
        }else{
            HappyScore = PH/(PH+PG);
        }

        bw.write(String.format("%.2f", HappyScore*100)+"");
        bw.flush();
        bw.close();


    }
}
