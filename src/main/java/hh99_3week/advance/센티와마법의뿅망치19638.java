package hh99_3week.advance;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 센티와마법의뿅망치19638 {
    /*
     * 입력 :
     * - 첫줄에 거인나라의 인구수 N / 센티의 키 H / 뿅망치 사용 가능 횟수 T
     * - 두 번째 줄부터 각 거인의 키를 나타내는 정수 H가 주어짐
     *
     * 연산 :
     * - 뿅망치를 사용하면 맞은 사람의 키가 (원래 키/2)로 줄어든다.
     * - 키가 1인 경우, 더 줄어들지 않는다.
     * - PriorityQueue를 사용해서 구현하자
     *
     * 출력 :
     * - 뿅망치의 횟수가 남아있는 동안 모든 거인의 키를 센티보다 작게 할 수 있으면 첫줄에 YES 출력
     * - 두번째 줄에 최소로 사용한 횟수
     *
     * - 다 사용하고도 더 큰 거인이 있으면 NO 출력
     * - 현재 거인의 나라에서 키가 가장 큰 거인의 키 출력
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> giantList = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int total = Integer.parseInt(st.nextToken());
        int centiHeight = Integer.parseInt(st.nextToken());
        int hammerCount = Integer.parseInt(st.nextToken()); //뿅망치 남은 횟수
        int attack = 0; // 때린 횟수
        for (int i = 0; i < total; i++) {
            giantList.add(Integer.parseInt(br.readLine()));
        }

        while (hammerCount>0){

            //센티의 키가 제일 큰 거인보다 크면 반복문에서 빠져나온다
            if(giantList.peek()<centiHeight){
                bw.write("YES");
                bw.newLine();
                bw.write(attack+" ");
                bw.flush();
                return;
            }

            //센티보다 큰 거인이 있으면
            //뿅망치를 사용한다(횟수차감 -1)
            hammerCount--;
            //공격횟수 기록
            attack++;
            //제일 큰 거인의 키가 반으로 줄어든다(줄어든 채로 다시 리스트에 넣음)
            //제일 큰 거인의 키가 1이면 그냥 1을 반환
            if(giantList.peek()<=1){
                break;
            }else{
                giantList.add(giantList.poll()/2);
            }

        }

        //뿅망치 횟수를 다 쓰고도 거인의 키가 더 크면 반복문 종료
        if(giantList.peek()>=centiHeight){
            bw.write("NO");
            bw.newLine();
            bw.write(giantList.peek()+" ");
        }else{
            bw.write("YES");
            bw.newLine();
            bw.write(attack+" ");
        }

        bw.flush();
        bw.close();

    }
}
