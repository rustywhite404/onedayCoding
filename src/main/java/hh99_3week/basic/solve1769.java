package hh99_3week.basic;

import java.io.*;

public class solve1769 {
    /*
    * 문제 분석 :
    * 자연수 X를 받아서, X가 3의 배수인지 답을 찾는 문제.
    * 최종적으로 나오는 수가 3의 배수인지 확인해서 출력.
    *
    * 입력: 자연수 x
    * 로직: 1. 주어진 문자열을 String 변수에 저장
    * 2. 주어진 자연수의 모든 자리수를 더한다.
    * 2-1. 모든 자리수를 더한 값이 1의 자리가 될때까지 1을 반복한다.
    * 2-2. 반복문을 돌면서 string 변수 업데이트
    * 3. 마지막 1의 자리가 3의 배수인지 확인
    * 4. 몇 번 1번을 반복했는지, 3의 배수인지 출력
    * 출력: 문제 변환 수(정수), 3의 배수이면 YES, 아니면 NO
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int count = 0;
        int result = recursiveSum(input, count);
//        //string 길이가 1이 될때까지 반복
//        while (input.length()>1){
//            int sum = 0;
//            for(int i=0;i<input.length();i++){
//                //string에서 char 가지고 와서 -0 하고 sum에 더함
//                sum += input.charAt(i) - '0';
//            }
//            input = String.valueOf(sum);
//            count++;
//        }
        //1의 자리가 된 수를 int로 형변환 해서 넣어준다
        //int result = Integer.parseInt(input);
        bw.write(count+" ");
        bw.newLine();
        bw.write((result%3==0)?"YES":"NO");
        bw.flush();
        bw.close();

    }

    private static int recursiveSum(String input, int count) {
        //input은 받아온 string, result는 결과값
        if(input.length()==1){
            return Integer.parseInt(input);
        }
        int sum = 0;
        // sum에 input의 i번째에 -0
        for(int i=0;i<input.length();i++){
            sum += input.charAt(i)-'0';
        }
        count++;
        return recursiveSum(String.valueOf(sum), count);

    }


}
