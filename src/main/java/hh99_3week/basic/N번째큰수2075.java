package hh99_3week.basic;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N번째큰수2075 {
    /*
     * 힙을 이용해보는 문제. N x N 의 숫자열이 주어진다.
     * 최대 힙을 구한 후에 위에서부터 꺼내고, N번째 값을 출력한다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); //최대값을 구할 힙 만들기.
        // 힙에 값 넣기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                maxHeap.add(Integer.parseInt(st.nextToken()));
            }
        }

        //힙에서 값 꺼내기. N-1번째까지 꺼내고 멈춘다
        for(int i=0;i<N-1;i++){
            maxHeap.poll();
        }

        //현재 힙에 남아있는 맨 위 수(N번째)를 꺼낸다
        bw.write(maxHeap.poll()+" ");
        bw.flush();
        bw.close();
    }
}
