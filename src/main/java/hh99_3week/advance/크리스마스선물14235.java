package hh99_3week.advance;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 크리스마스선물14235 {
    /*
     * 입력 :
     * - 첫번쨋줄 : 아이들과 거점지를 방문할 횟수 N
     * - 2~N : A가 0이면 아이를 만난 것. 선물을 줘야한다. 선물이 없으면 -1 출력
     * - 2~N : A가 0이 아니면 거점지에 도착해서 A개의 선물을 충전한 것이다. 각 선물의 가치는 이후에 입력된 숫자이다.
     * - 선물은 가장 가치가 있는 것을 전달한다.
     *
     * - 출력 : A가 0일 때 마다 아이들에게 준 선물의 가치를 출력해라. 선물이 없었다면 -1.
     *
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine()); //방문할 횟수
        PriorityQueue<Integer> presentList = new PriorityQueue<Integer>(Collections.reverseOrder()); //최댓값이 맨 위로 올라가도록 힙 생성
        for (int i = 0; i < total; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int pointToInt = Integer.parseInt(st.nextToken());
            if(pointToInt==0){ //아이를 만났다면
                if(presentList.isEmpty()){
                    //가진 선물이 없다면
                    bw.write("-1");
                    bw.newLine();
                }else{
                    bw.write(presentList.poll()+" "); //가진 선물이 있다면 가장 가치있는 것을 꺼내줌
                    bw.newLine();
                }
            }else{
                //거점에 도착한거라면
                while (st.hasMoreTokens()){
                    presentList.add(Integer.valueOf(st.nextToken()));
                }
            }
        }
        bw.flush();
        bw.close();

    }
}
