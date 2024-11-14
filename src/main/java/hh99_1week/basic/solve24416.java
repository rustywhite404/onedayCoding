package hh99_1week.basic;

import java.io.*;

public class solve24416 {

    /*
    * 문제 분석 :
    * - n을 입력받아 재귀호출, 동적 프로그래밍으로 실행한 후
    * - 각각의 방식이 몇 번이나 실행되는지 출력한다
    *
    * 풀이 전략 :
    * - n을 입력받는다
    * - 재귀호출, 동적 프로그래밍 메서드를 각각 만든다
    * - 각각의 코드가 실행된 횟수를 카운트하는 변수를 만든다
    * - 코드가 실행 될 때 마다 변수를 카운트하여 최종 결과를 출력
    * */
    static int fib_count = 0; // 피보나치 수 재귀 호출 카운트
    static int fibonacci_count = 0; // 피보나치 수 동적 프로그래밍 호출 카운트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()); // 예제 숫자 입력 받기

        fib(n);
        fibonacci(n);

        // 출력
        bw.write(fib_count+" "+fibonacci_count);
        bw.flush();
        bw.close();
    }

    // 피보나치 수 재귀 호출 코드
    public static int fib(int n) {
        if (n == 1 || n == 2) {
            fib_count++;
            return 1;
        }else{
            return fib(n-1)+fib(n-2);
        }
    }

    // 피보나치 수 동적 프로그래밍 의사 코드
    public static int fibonacci(int n){
        if(n==1||n==2){
            return 1;
        }
        int[] f = new int[n+1];
        f[1] = 1;
        f[2] = 1;
        for(int i=3;i<=n;i++){
            f[i] = f[i-1]+f[i-2];
            fibonacci_count++;
        }
        return f[n];
    }

}
