package hh99_3week.advance;

import java.io.*;
import java.util.PriorityQueue;

public class 카드정렬하기1715 {
    /*
    * 입력 :
    * - 첫줄에 N번의 횟수가 주어진다
    * - 둘쨋줄부터 N개의 줄에 카드 묶음의 크기가 각각 주어진다.
    *
    * - 풀이 :
    * - 탐욕 알고리즘과 우선순위 큐를 사용해서 풀어야 한다.
    * - 제일 작은 카드뭉치끼리 더하기를 반복해서 한 덩어리가 남았을 때 종료한다.
    *
    * - 출력 : 서로를 더해서 한 덩어리를 만들었을 때 최소값을 구해야 한다
    *
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue();

        //힙에 숫자 묶음 입력
        for(int i=0;i<total;i++){
            queue.add(Integer.parseInt(br.readLine()));
        }
        int result = 0;
        while (queue.size()>1){
            int sum = queue.poll()+queue.poll();
            result += sum;
            queue.add(sum);
        }
        bw.write(result+" ");
        bw.flush();
        bw.close();
    }
}
