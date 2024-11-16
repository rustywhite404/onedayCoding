package hh99_1week.basic;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class solve2605 {
    /*
    - 문제 분석 :
    - 처음에 학생의 총 수가 주어진다. 이 수만큼 반복한다.
    - 학생들은 각각 자신의 번호 수 만큼의 수 집합에서 숫자를 뽑는다
    - 0번을 뽑으면 제자리에, 1을 뽑으면 1칸 앞으로, 2를 뽑으면 2칸 앞으로(...) 이동한다.
    - 최종 순서를 구하자.

    - 풀이 전략 :
    - * 실수했던 부분 : 학생들이 뽑는 순번을 랜덤으로 구현해야 한다고 생각해서 어렵게 짜다가 나중에야 입력값으로 그냥 들어온다는 걸 인지함
    - list에 각자를 추가하되 뽑은 숫자가 0이 아니면 뽑은 숫자만큼 순서를 당기고, 그 자리에 학생의 고유번호를 입력한다.
    - ArrayList보다 LinkedList가 삽입, 삭제가 빠르다고 해서 잦은 삽입이 생기는 문제인 것 같아 LinkedList를 사용하기로 했다.
     */
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        List<Integer> list = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i=0;i<total;i++){
           int num = Integer.parseInt(st.nextToken());
           if(!(num==0)){
               list.add(i-num,i+1);
           }else{
               list.add(i,i+1);
           }
        }

        for (Integer integer : list) {
            bw.write(integer+" ");
        }
        bw.flush();
        bw.close();
    }
}
