package hh99_3week.advance;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 센티와마법의뿅망치19638_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = Integer.parseInt(st.nextToken());
        int centiHeight = Integer.parseInt(st.nextToken());
        int hammerCount = Integer.parseInt(st.nextToken());
        int attack = 0;
        PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder());
        //거인의 키 입력
        for (int i = 0; i < count; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        //센티의 키가 거인들보다 크다면 반복할 필요 없이 바로 종료
        if(centiHeight>queue.peek()){
            bw.write("YES");
            bw.newLine();
            bw.write(attack+" ");
            bw.flush();
            return;
        }

        //센티보다 큰 거인이 있다면 망치의 남은 횟수만큼 때리기 시작
        while (hammerCount>0){

            if(queue.peek()==1){ //거인의 키가 1이면 종료
                break;
            }
            if(queue.peek()>=centiHeight){
                hammerCount--;
                attack++;
                queue.add(queue.poll()/2);
            }else{ //센티가 제일 크다면
                break;
            }
        }

        //망치 횟수를 다 썼는데도 센티보다 큰 거인이 남아있다면
        if(queue.peek()>=centiHeight){
            bw.write("NO");
            bw.newLine();
            bw.write(queue.poll()+" ");
        }else{
            bw.write("YES");
            bw.newLine();
            bw.write(attack+" ");
        }
        bw.flush();
        bw.close();


    }
}
