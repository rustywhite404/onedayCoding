package hh99_3week.basic;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 콘서트16466 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int soldOut = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < soldOut; i++) {


            queue.add(Integer.parseInt(st.nextToken()));
        }
        int myTicketNum = 1;

        if(queue.isEmpty()) {
            bw.write(myTicketNum+" ");
        }
        //내가 고른 최소값이 큐에 이미 들어있으면 증가
        while (queue.contains(myTicketNum)) {
            queue.poll();
            myTicketNum++;
        }
        //해당하는 티켓 번호가 큐에 없으면 가져오기
        bw.write(myTicketNum+" ");
        bw.flush();
        bw.close();
    }

}

