package hh99_3week.basic;

import java.io.*;

public class 삼의배수 {
    /*
     * 입력 :
     * - 자연수 X가 주어진다
     *
     * 연산 :
     * - X의 각 자릿수의 값을 더한 수 Y를 만든다
     * - Y가 한자릿수가 될 때까지 각 자릿수의 값을 더하는 변환을 진행한다
     * - 한자릿수가 된 Y가 3의 배수(3,6,9)중 하나라면 3의 배수이다.
     *
     * 출력 :
     * - 몇 번의 변환을 거쳤는지 출력
     * - 주어진 수가 3의 배수인지(YES/NO)를 출력한다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        String num = input;
        int count = 0;
        int sum = 0;
        while (num.length() > 1) {
            sum = 0;
            for (int i = 0; i < num.length(); i++) {
                sum += Character.getNumericValue(num.charAt(i));
            }
            num = String.valueOf(sum);
            count++;
        }

        bw.write(count + " ");
        bw.newLine();
        if (Integer.parseInt(num) % 3 == 0) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }

        bw.flush();
        bw.close();
    }
}
