package hh99_3week.basic;

import java.io.*;
import java.util.*;

public class 국회의원선거1417 {
    /*
     * 입력 :
     * - 후보의 수 N
     * - 둘쨋줄부터 1번을 찍으려는 사람의 수
     * - 2번을 찍으려는 사람의 수 (... )
     * - N번을 찍으려는 사람의 수  가 주어진다.
     *
     * 연산 :
     * - 1번 사람이 가장 많은 득표수를 가질 때까지 아래 내용을 반복
     * - 1번보다 득표수가 많거나 같은 사람들을 확인한다
     * - 이 사람들에게서 각각 1표를 가져온다(가져올 때 마다 count 증가)
     * 출력 :
     * - 매수해야 하는 사람의 최솟값을 출력
     *
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine()); //후보의 수
        int count = 0; //매수 횟수
        List<Integer> votes = new ArrayList<>(); //후보들의 득표 수를 저장할 리스트


        //각 후보들이 가진 득표수 초기값 세팅
        for (int i = 0; i < total; i++) {
           votes.add(Integer.parseInt(br.readLine()));
        }

        // 1번 후보의 득표수가 가장 많을 때까지 반복
        while (true) {
            int maxValue = Collections.max(votes); //최댓값 찾기(계속해서 갱신)

            //1번 후보의 득표수가 가장 많으면
            if(votes.get(0)==maxValue){
                //1번 후보와 표수가 같은 후보가 있는지 확인
                boolean equalCount = true;
                for (int i = 1; i < total; i++) {
                    if (votes.get(0) == votes.get(i)) { //표수가 같은 사람이 다른 후보중에 있다면
                        equalCount = false;
                        break;
                    }
                }
                if(equalCount){ //1번 후보가 최댓값을 가지고, 동률이 없으면 종료
                    break;
                }
            }

            //1번 후보보다 많은 득표수를 가진 후보에게서 1표씩 빼기
            for (int i=1;i<total;i++){
                if(votes.get(i)==maxValue){ //1번이 아닌데도 최대득표수를 가진 후보가 있다면
                    votes.set(i, votes.get(i)-1); //이 후보에게서 1표를 가져옴
                    votes.set(0,votes.get(0)+1); //1번 후뵤에게 1표를 더함
                    count++; //매수 횟수 증가
                    break; //한 번에 한 후보에게서만 표를 가져오므로 break;
                }
            }

        }
            bw.write(count+" ");
            bw.flush();
            bw.close();
        }
    }
