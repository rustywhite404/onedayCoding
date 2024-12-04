package hh99_4week.basic;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 보물1026 {

    /*
    * 입력 :
    * - 길이 N이 주어짐
    * - 길이 N인 배열 A가 주어짐
    * - 길이 N인 배열 B가 주어짐
    *
    * 연산 :
    * - S = A[0] * B[0]...
    * - S의 값을 가장 작게 만들기 위해 A의 수를 재배열
    * => 전에 이 문제 B를 재배열하지 말라고 해서 B의 값들을 고정해 둔 채로 풀었는데, 다른 사람들 풀이를 보니
    * B도 SORT해서 A의 최소값과 B의 최대값을 곱해도 정답 처리가 되는 것 같았다(내가 문제를 잘못 해석한건지 모르겠다)
    * 우선 최소값과 최대값을 곱해서 요구하는 S를 만들어보았다.
    *
    * 출력 :
    * - S의 최솟값을 입력
    *
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> A = new PriorityQueue<>();
        PriorityQueue<Integer> B = new PriorityQueue<>(Collections.reverseOrder());
        //배열 A 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<total; i++){
            A.add(Integer.parseInt(st.nextToken()));
        }

        //배열 B 초기화
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<total; i++){
            B.add(Integer.parseInt(st.nextToken()));
        }

        int sum = 0;
        for(int i=0;i<total;i++){
            sum += A.poll()*B.poll();
        }
        bw.write(sum+" ");
        bw.flush();
        bw.close();
    }
}
