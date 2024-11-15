package hh99_1week.basic;

import java.io.*;

public class solve26041 {
    /*
     * 문제 해석 :
     * - n개의 전화번호가 공백으로 구분된 문자열 A
     * - 하나의 문자열 B
     * - 문자열 A에 포함된 전화번호 중에 B가 포함되어 있으면서 B와 완전히 일치하지는 않는 전화번호의 갯수 카운트
     *
     * 풀이 전략 :
     * - equals()로 완전히 일치하는지 한 번 걸러낸 후에 contains로 포함되어 있는지 찾으면 될 것 같다
     * => 에러가 나서 문제를 다시 확인해보니 '접두사'일 때만 취급한다. startsWith를 사용해야 함.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] numList = br.readLine().split(" ");
        int correctNum = 0;
        String num = br.readLine();
        for (int i = 0; i < numList.length; i++) {
            if(!num.equals(numList[i])){
                if(numList[i].startsWith(num)){
                    correctNum++;
                }
            }
        }
        bw.write(correctNum+"");
        bw.flush();
        bw.close();
    }
}
