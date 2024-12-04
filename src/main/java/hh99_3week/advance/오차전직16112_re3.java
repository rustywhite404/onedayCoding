package hh99_3week.advance;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 오차전직16112_re3 {
    /*
    * 입력 :
    * - 첫줄에 퀘스트 수 N, 사용 가능한 아이템 수 M이 주어짐
    * - 두번째 줄에 퀘스트 별 경험치가 주어짐
    *
    * 연산 :
    * - 경험치가 제일 높은 퀘스트를 뒤로 배치(우선순위 큐)
    * - 아이템에 값을 누적시키기
    * - => 우선순위 큐와 HashMap을 이용하니까 시간초과가 떠서 배열로 변경해봄
    *
    * 출력 :
    * - 모든 퀘스트를 진행했을 때 최대로 받을 수 있는 경험치를 출력
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int questAmount = Integer.parseInt(st.nextToken()); //퀘스트 수
        int itemAmount = Integer.parseInt(st.nextToken()); //사용 가능한 아이템 수
        //long[] exps;
        long result = 0;
        //exps = new long[questAmount];
        PriorityQueue<Long> exps = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<questAmount;i++){
            exps.add(Long.parseLong(st.nextToken()));
        }


        //최대 활성화 아이템을 곱한 경험치 합산
        long count = 0; //활성화 아이템 수
        for(int i=0;i<questAmount;i++){
            result += exps.poll()*count;
            if(count<itemAmount){ //아직 더 활성화 할 수 있으면
                count++;
            }
        }

        bw.write(result+" ");
        bw.flush();
        bw.close();
    }
}
