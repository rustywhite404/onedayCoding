package hh99_3week.basic;


import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 세준세비1524 {
    /*
     * 입력 :
     * - 테스트 케이스의 개수 T
     * - 공백으로 테스트케이스 구분
     * - 테스트 케이스 첫줄 : 세준이의 병사 N명, 세비의 병사 M명
     * - 둘째줄 : 세준이의 병사들의 힘
     * - 셋째줄 : 세비의 병사들의 힘
     *
     * 연산 :
     * - 각 전투에서 전투력이 가장 약한 병사가 죽는다
     * - 양쪽의 최약체 전투력이 동일하다면, 세비의 병사가 죽는다
     * - 둘 중에 한쪽의 병사가 다 죽었을 때 종료
     *
     * 출력 :
     * - 각 테스트케이스에 대해 한 줄에 하나씩 승자를 출력한다
     * - 세준이가 이기면 S, 세비가 이기면 B, 둘 다 아닐 경우는 C
     *
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> sejunArmyPower;
        PriorityQueue<Integer> sebiArmyPower;

        int totalCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < totalCount; i++) {
            String blank = br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            sejunArmyPower = new PriorityQueue<>();
            sebiArmyPower = new PriorityQueue<>();
            int sejunArmy = Integer.parseInt(st.nextToken());
            int sebiArmy = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine()," ");
            //세준이의 병사들 전투력 입력
            for (int j = 0; j < sejunArmy; j++) {
                sejunArmyPower.add(Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine()," ");
            //세비의 병사들 전투력 입력
            for (int j = 0; j < sebiArmy; j++) {
                sebiArmyPower.add(Integer.parseInt(st.nextToken()));
            }

            //전투 시작
            while (!sejunArmyPower.isEmpty() && !sebiArmyPower.isEmpty()) { //한쪽이라도 전멸하면 종료
                if (sejunArmyPower.peek() >= sebiArmyPower.peek()) {
                    sebiArmyPower.poll();
                } else {
                    sejunArmyPower.poll();
                }
            }

            //전투 종료 후
            if (sejunArmyPower.isEmpty() && sebiArmyPower.isEmpty()) { //둘 다 전멸이면
                bw.write("C");
                bw.newLine();
            } else if (sejunArmyPower.isEmpty()) {
                bw.write("B");
                bw.newLine();
            } else {
                bw.write("S");
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}
