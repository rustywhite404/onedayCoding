package 문자열;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class 히든넘버8595 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int length = Integer.parseInt(br.readLine());
        String words = br.readLine();
        List<String> numbers = new ArrayList<>();

        StringBuilder currentNumber = new StringBuilder();
        long sum = 0;

        //문자열의 각 문자 확인
        for (char c : words.toCharArray()) {
            if(Character.isDigit(c)){ //숫자라면
                currentNumber.append(c); //숫자 덧붙이기
            }else {
                //숫자가 아니라면
                if(currentNumber.length()>0){ //Stringbuilder에 저장된 문자열 덩어리가 있다면
                    if (currentNumber.length() <= 6) { // 6자리 이하인 경우만 처리
                        sum += Long.parseLong(currentNumber.toString());
                    }
                    currentNumber.setLength(0); //덩어리 초기화
                }
            }
        }

        // 마지막 숫자 덩어리 처리
        if (currentNumber.length() > 0 && currentNumber.length() <= 6) {
            sum += Long.parseLong(currentNumber.toString());
        }

        //결과 출력
        bw.write(sum+"");
        bw.flush();
        bw.close();
    }
}
