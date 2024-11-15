package hh99_1week.basic;

import java.io.*;
public class solve1152 {
    /*
    * 문제 분석 :
    * - 영어 대소문자와 공백으로 이루어진 문자열을 입력받는다
    * - 이 문자열이 몇 개의 어절로 이루어져 있는지 계산한다
    *
    * 풀이 전략 :
    * - 입력받은 문자열을 공백 기준 split으로 잘라 배열에 넣고, 배열의 길이를 구하자.
    * +) 배열에 null이나 공백이 포함되어 있으면 삭제한다
    * - removeAll(null)을 사용하려 했는데 Array.asList는 remove 사용이 불가능하다고 해서...
    * 입력받은 문자열에서 trim으로 양 끝의 공백을 제거하고 카운팅하기로 했다.
    * 비고 :
    * - 예시로 있던 입력값은 기대값이 다 맞았는데, 공백만 입력되었을 경우를 제대로 처리하지 못해서 틀렸다고 나왔다.
    * - 이 경우를 처리하기 위해 각 문자의 길이를 계산해서 값이 있을 때만 카운트 하도록 처리했다.
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine().trim();
        String[] wordList = word.split(" ");
        int count = 0;
        for(int i=0; i<wordList.length;i++){
            if(wordList[i].length()>0){
                count++;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
