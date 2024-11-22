package hh99_2week.basic;

import java.io.*;
import java.util.Arrays;

public class solve10989_re {
    /*
    - 문제 분석 :
    - N개의 수가 주어졌을 때 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
    - 풀이 전략 :
    - 원래 ArrayList와 Collection.sort()를 이용해서 구현했었는데, 메모리 초과가 떴다.
    - 이 문제에서는 데이터의 크기가 미리 주어지므로 배열을 통해 구현이 가능하고,
    - 배열은 고정 크기의 메모리만 사용하므로 메모리 사용량을 줄일 수 있다.
    - 그래서 리스트를 배열로 바꾸고, Collection 대신 Arrays에서 sort()했더니 통과함.
    - Array.sort()보다 효과적인 Counting sort 방식으로도 풀어보았다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 여기서는 Counting sort를 사용해서 풀어본다.
        int count = Integer.parseInt(br.readLine());
        int[] list = new int[10001]; //숫자의 범위는 1~10,000

        //1. 입력 숫자를 카운트 배열에 기록
        for(int i=0;i<count;i++){
            int num = Integer.parseInt(br.readLine());
            list[num]++;
        }

        // 2. 카운트 배열을 순회하며 정렬된 결과 출력
        for(int i=1;i<list.length;i++){
            while (list[i]>0){
                bw.write(i+" ");
                list[i]--;
            }
        }

        bw.flush();
        bw.close();

    }
}
