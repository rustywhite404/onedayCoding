package hh99_4week.basic;

import java.io.*;
import java.util.*;

public class 신입사원1946 {
    /*
     * 입력 :
     * - 1. 테스트의 개수 T
     * - 2. 테스트케이스 1의 지원자 수 N
     * - 3~N. 각각의 지원자의 서류 심사 성적, 면접 성적 순위가 주어짐
     *
     * 연산 :
     * - 서류심사 성적으로 먼저 정렬
     * - 서류심사 1등의 면접성적을 기준 면접 성적 점수 A로 설정(서류심사 1등은 무조건 합격)
     * - 서류심사 2등의 면접 성적이 A보다 높다면 합격자 수++, 기준 점수를 변경
     * - 서류심사 2등의 면접 성적이 A이하라면 불합격
     * (반복)
     *
     * 출력 :
     * 케이스 별로 뽑힐 수 있는 최대 인원수를 한줄에 하나씩 출력
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int caseAmount = Integer.parseInt(br.readLine());
        for (int i = 0; i < caseAmount; i++) {
            int person = Integer.parseInt(br.readLine());
            PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getKey));

            //서류심사 성적순으로 우선순위 큐에 입력
            for (int j = 0; j < person; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                queue.add(new AbstractMap.SimpleEntry<>(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            int count = 1; //합격자 카운트. 서류심사 1등이 무조건 합격이므로 1명부터 시작
            int currentRank = queue.poll().getValue(); //면접 기준 순위
            for (int j = 0; j < person-1; j++) {
                if (!queue.isEmpty()) {
                    int nextRank = queue.poll().getValue();
                    if (currentRank > nextRank) { //뒤에 있는 사람의 순위가 더 높으면
                        count++;
                        currentRank = nextRank; //기준 순위 갱신
                    }
                }
            }
            bw.write(count + " ");
            bw.newLine();

        }
        bw.flush();
        bw.close();
    }
}
