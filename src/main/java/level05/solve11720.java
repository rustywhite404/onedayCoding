package level05;

import java.io.*;

public class solve11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        String word = br.readLine();
        int wordLength = word.length();
        int sum = 0;
        for(int i=0;i<wordLength;i++){
            //sum += Integer.parseInt(String.valueOf(word.charAt(i)));
            //.getNumericValue를 이용하면 StringValueOf를 거치지 않고 바로 쓸 수 있다(유니코드의 값을 int로 반환)
            sum += Character.getNumericValue(word.charAt(i));
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
