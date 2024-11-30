package hh99_3week.advance;

import java.io.*;
import java.io.BufferedReader;
import java.util.*;

public class 문제추천시스템버전1_21939 {
    /*
     * 입력 :
     * - 문제의 개수 N
     * - 두번째 줄부터 N+1까지 문제번호 P와 난이도 L이 공백으로 구분되어 주어짐
     * - 끝나고나면 입력될 명령문의 개수 M이 주어짐
     * - M개의 명령문이 입력된다
     *
     * 연산 :
     * - 가장 쉬운 문제, 가장 어려운 문제 각각의 우선순위 큐를 만든다
     * - (TreeMap을 사용할 지도 고민했는데 항상 최상위 값만 꺼낼 예정이고, 중복값들이 있으므로 우선순위 큐를 써보기로 함)
     * - recommend x가 들어왔을 때 :
     * - 우선순위 큐의 정렬 조건에서 가장 어려운 값부터 꺼내되, 같은 값이 여러개라면 문제번호가 큰 것으로 출력하도록 정의.
     * - 키값을 비교해야 하므로 우선순위 큐에 넣을 자료형을 TreeMap이나 HashMap으로 해야 할 것 같다
     * - recommend -x도 동일
     * - add P L :
     * - 우선순위 큐에 입력받은 <난이도L, 문제번호P>를 추가.
     * - solved P :
     * - 입력받은 P번 문제를 삭제한다. 우선순위 큐는 중간값 삭제에는 적합하지 않아서 TreeSet을 사용하는 걸로 전략 변경.
     * - 풀면서 헤맸던 부분 :
     * - recommend의 출력 조건에 따라 정렬을 여러번 해야 한다고 생각했는데
     * - 테스트 데이터들을 실제로 정렬시켜 보니 난이도 기준 오름차순 -> 문제의 난이도가 같다면 문제명 기준 오름차순으로 쭉 정렬해두면
     * - 최대값이나 최소값을 찾을 때 알아서 조건에 맞게 정렬된다.
     *
     * 출력 :
     * - 각 명령이 주어질 때 마다 문제 번호를 한 줄씩 출력한다
     * - recommend 1인 경우 가장 어려운 문제의 번호를 출력한다(가장 어려운 문제가 여러개라면 문제번호가 큰 것으로 출력)
     * - recommend -1인 경우 가장 쉬운 문제의 번호를 출력한다(여러개라면 문제 번호가 작은 것으로 출력)
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int totalCount = Integer.parseInt(br.readLine());
        TreeSet<Quest> questList = new TreeSet<>(new Comparator<Quest>() {
            @Override
            public int compare(Quest o1, Quest o2) {
                //문제의 난이도가 같다면
                if (o1.level == o2.level) {
                    return o1.questNum - o2.questNum;
                    //return Integer.compare(o1.level,o2.level);
                }
                //문제 난이도가 다른 경우 오름차순
                return o1.level - o2.level;
                //return Integer.compare(o1.questNum, o2.questNum);
            }
        });

        //문제번호-난이도 쌍을 관리
        Map<Integer, Integer> map = new HashMap<>();

        //문제 리스트 생성
        for (int i = 0; i < totalCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int questNum = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            map.put(questNum, level);
            questList.add(new Quest(questNum, level));
        }

        //명령의 갯수
        int order = Integer.parseInt(br.readLine());

        for (int i = 0; i < order; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "add":
                    int questNum = Integer.parseInt(st.nextToken());
                    int level = Integer.parseInt(st.nextToken());
                    questList.add(new Quest(questNum, level));
                    map.put(questNum,level);
                    break;
                case "solved":
                    int deleteNum = Integer.parseInt(st.nextToken());
                    int deleteLevel = map.get(deleteNum);
                    questList.remove(new Quest(deleteNum, deleteLevel));
                    break;
                case "recommend":
                    if(Integer.parseInt(st.nextToken())==1){
                        //가장 어려운 문제의 번호 출력.
                        bw.write(questList.last().questNum+" ");
                        bw.newLine();
                    }else{
                        //가장 쉬운 문제의 번호 출력.
                        bw.write(questList.first().questNum+" ");
                        bw.newLine();
                    }
                    break;

            }
        }

        bw.flush();
        bw.close();

    }

    //퀘스트 클래스를 정의
    static class Quest {
        int questNum; //문제 번호
        int level; // 레벨

        public Quest(int questNum, int level) {
            this.questNum = questNum;
            this.level = level;
        }
    }
}
