package hh99_3week.advance;

import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 오차전직16112 {
    /*
    * 입력 :
    * - 첫줄에 퀘스트 수 N, 사용 가능한 아이템 수 M이 주어짐
    * - 두번째 줄에 퀘스트 별 경험치가 주어짐
    *
    * 연산 :
    * - 경험치가 제일 높은 퀘스트를 뒤로 배치(우선순위 큐)
    * - 아이템에 값을 누적시키기
    * - => 시간 초과가 떠서 배열을 사용해서 다시 풀어봤는데도 시간초과가 뜸. 나중에 해결법을 더 고민해봐야겠다
    *
    * 출력 :
    * - 모든 퀘스트를 진행했을 때 최대로 받을 수 있는 경험치를 출력
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long questAmount = Long.parseLong(st.nextToken()); //퀘스트 수
        int itemAmount = Integer.parseInt(st.nextToken()); //사용 가능한 아이템 수
        int myItemAmount = 0; //현재 내가 가진 아이템 수
        Map<Integer, Long> map = new HashMap<>(); //아이템번호, 누적경험치
        PriorityQueue<Long> questList = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        //퀘스트와 경험치 초기화
        for(int i=0;i<questAmount;i++){
            questList.add(Long.parseLong(st.nextToken()));
        }

        for(int i=0;i<questAmount;i++){
            //내가 가진 아이템이 존재하면 획득한 경험치를 넣는다
            if(!map.isEmpty()){
                Long currentExp = questList.poll();
                for(int j=0;j<map.size();j++){
                    map.put(j,map.get(j)+currentExp);
                }

                //내가 가진 아이템 수가 아직 최대치가 아니라면 map에 아이템 하나를 추가한다
                if(myItemAmount<itemAmount){
                    map.put(myItemAmount++,0L);
                }

            }else{ //아직 가진 게 없으면 아이템 하나를 추가한다
                questList.poll();
                map.put(myItemAmount++,0L);
            }

        }

        Long result = 0L;
        for (Long value : map.values()) {
            result += value;
        }
        bw.write(result+" ");
        bw.flush();
        bw.close();
    }
}
