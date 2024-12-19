package 문자열;

import java.io.*;
import java.util.Stack;

public class 이진수나눗셈22950 {
    /*
    * String을 Integer로 변환하며 2진수를 10진수로 바꾼 후 2로 나누어 떨어지는지 계산
    *
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine()); //입력받은 M의 자리수
        Stack<Integer> num = new Stack<>();
        String binary = br.readLine(); //입력받은 이진수 M을 한 자리씩 스택에 저장
        for(int i=0;i<total;i++){
            num.push(binary.charAt(i)-'0'); //문자를 숫자로 변환
        }
        //입력받은 K값
        int devide = Integer.parseInt(br.readLine());

        //마지막 K개의 숫자를 확인
        for(int i=0;i<devide;i++){
            if(num.isEmpty()){
                break;
            }
            int topNum = num.pop(); //스택에서 숫자를 꺼냄
            if(topNum!=0){
                bw.write("NO");
                bw.flush();
                return;
            }
        }

        bw.write("YES"); //모든 조건을 만족하면 YES
        bw.flush();
        bw.close();
    }
}
