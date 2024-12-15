package 문자열;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class 히든넘버8595_re {
    public static void main(String[] args) throws IOException {
        //히든 넘버는 6자리를 넘지 않는다
        //연속된 숫자는 한 히든 넘버이다
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String word = br.readLine();
        List<String> numberList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        long sum = 0;
        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                if (sb.length() > 0 && sb.length() <= 6) {
                    sum += Long.parseLong(sb.toString());
                }
                sb.setLength(0);
            }
        }

        //마지막 숫자 덩어리 처리
        if (sb.length() > 0 && sb.length() <= 6) {
            sum += Long.parseLong(sb.toString());
        }
        bw.write(sum+" ");
        bw.flush();
        bw.close();
    }
}
