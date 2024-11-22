package hh99_2week.basic;

import java.io.*;
import java.util.*;

public class solve10989 {
    /*
    - 문제 분석 :
    - N개의 수가 주어졌을 때 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
    - 풀이 전략 :
    - 원래 ArrayList와 Collection.sort()를 이용해서 구현했었는데, 메모리 초과가 떴다.
    - 이 문제에서는 데이터의 크기가 미리 주어지므로 배열을 통해 구현이 가능하고,
    - 배열은 고정 크기의 메모리만 사용하므로 메모리 사용량을 줄일 수 있다.
    - 그래서 리스트를 배열로 바꾸고, Collection 대신 Arrays에서 sort()했더니 통과함.
    - Array.sort()보다 효과적인 Counting sort 방식으로도 풀어보자.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        int[] list = new int[count];
        //리스트 초기화
        for(int i=0;i<count;i++){
            list[i] = (Integer.parseInt(br.readLine()));
        }
        Arrays.sort(list);
        for (int i : list) {
            bw.write(i+" ");
            bw.newLine();
        }
        bw.flush();
        bw.close();

    }
}
