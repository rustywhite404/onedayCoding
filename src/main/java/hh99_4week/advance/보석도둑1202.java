package hh99_4week.advance;

import java.io.*;
import java.util.*;

public class 보석도둑1202 {
    /*
    * 입력 :
    * - 첫줄 : 보석 숫자 N / 가방숫자 K
    * - 둘째줄부터 ~ N : 보석의 무게 M / 가격 V
    * - 마지막에 가방의 최대 무게 C
    *
    * 연산 :
    * - 보석의 <가격, 무게>를 가격순으로 내림차순 한다.
    * - 가방은 작은 순으로 정렬한다.
    * - 가방의 남은 칸에 비싼 것부터 대봤을 때 들어간다면 넣고, 남은 공간의 수를 줄인다
    * - 안 들어간다면 다음 가방의 남은 칸에 대본다.
    * - 모든 가방에 안들어간다면 버리고 다른 보석을 넣는다
    * (반복)
    *
    * 출력 :
    * - 훔칠 수 있는 최대 가격을 구하시오
    *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int jewelAmount = Integer.parseInt(st.nextToken()); //보석 수량
        int bagAmount = Integer.parseInt(st.nextToken()); //가방 숫자

        //보석 배열<무게, 가격>
        Jewel[] jewels = new Jewel[jewelAmount];
        for(int i=0;i<jewelAmount;i++){
            st = new StringTokenizer(br.readLine());
            jewels[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        //가방 배열
        int[] bags = new int[bagAmount];
        for(int i=0;i<bagAmount;i++){
            bags[i] = Integer.parseInt(br.readLine());
        }

        //보석은 무게 기준 오름차순 정렬, 무게가 같다면 가격 내림차순
        Arrays.sort(jewels, (a, b) -> {
            if(a.weight==b.weight){ //무게가 같다면
                return b.value - a.value; //가격 내림차순
            }else{
                return a.weight - b.weight; //무게 오름차순
            }
        });

        //가방 : 용량 기준 오름차순
        Arrays.sort(bags);

        //우선순위 큐 : 가격 기준 내림차순
        PriorityQueue<Integer> jewelList = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        int jewelIndex = 0;

        //가방을 순회하며 처리

        for(int i=0;i<bagAmount;i++){
            //현재 가방에 담을 수 있는 모든 보석을 큐에 넣음
            while (jewelIndex<jewelAmount && jewels[jewelIndex].weight<=bags[i]){
                jewelList.add(jewels[jewelIndex].value);
                jewelIndex++;
            }

            //우선순위 큐에 넣은 것 중에 가장 비싼 보석을 가방에 담음
            if(!jewelList.isEmpty()){
                sum += jewelList.poll();
            }
        }

        bw.write(sum+" ");
        bw.flush();
        bw.close();

    }

    private static class Jewel {
        int weight;
        int value;

        Jewel(int weight, int value){
            this.weight = weight;
            this.value = value;
        }
    }
}
