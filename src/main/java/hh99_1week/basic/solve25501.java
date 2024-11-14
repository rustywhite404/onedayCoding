package hh99_1week.basic;

import java.io.*;

public class solve25501 {

    /*
    * 문제 분석 :
    * - 팰린드롬이란 앞에서부터 읽었을 때와, 뒤에서부터 읽었을 때가 같은 문자열이다. (ex. ABBA)
    * - isPalindrome함수를 작성한다. 주어진 문자열이 팰린드롬이면 1, 아니면 0을 반환한다.
    * - 팰린드롬인지 확인하기 위해 recursion 함수를 작성하고, 몇 번 호출되는지 센다.
    * - 입력값 첫째 줄에 테스트케이스 갯수 T, 둘째 줄부터 T개의 문자열 S가 주어진다.
    *
    * 풀이 전략 :
    * - 테스트케이스 갯수 T를 입력받는다
    * - 문자열 S들을 입력받는다(T번 반복)
    * - 입력받은 문자열S가 팰린드롬인지 확인하는 recursion를 작성한다.
    * - recursion이 호출 될 때 마다 recursionCount를 센다.
    * - recursion에 따라 팰린드롬 여부를 반환하는 isPalindrome를 작성한다.
    * -
    * - 재귀호출, 동적 프로그래밍 메서드를 각각 만든다
    * - 각각의 코드가 실행된 횟수를 카운트하는 변수를 만든다
    * - 코드가 실행 될 때 마다 변수를 카운트하여 최종 결과를 출력
    * */
    static int recursionCount = 0; // recursion호출 횟수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 갯수 T
        for(int i=0;i<T;i++){
            recursionCount = 0; //recursionCount 초기화
            String word = br.readLine();
            bw.write(isPalindrome(word)+" "+recursionCount);
            bw.newLine();
        }
        bw.flush();
        bw.close();

    }

    public static int recursion(String s, int l, int r){
        recursionCount++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }


}
