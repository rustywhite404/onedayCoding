package hh99_2week.basic;

import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class solve1966 {

    /*
     * 문제 분석 :
     * - 현재 큐에 있는 문서의 수와 중요도가 주어졌을 때, 각 테스트 케이스에 대해 문서가 몇 번째로 인쇄되는지 출력한다.
     * - 현재 큐에서 가장 앞에 있는 문서의 중요도를 확인하고, 나머지 중 중요도가 더 높은 문서가 하나라도 있다면 현재 문서를 인쇄하지 않고 맨 뒤로 보낸다.
     * - 현재 문서가 제일 중요하다면 바로 인쇄.
     * - 첫 줄 : 테스트 케이스의 수. (각 테스트 케이스는 2줄로 이루어짐)
     * - ----------------------------------
     * - 둘째줄 : 테스트케이스 1 -> 문서의 개수 N / M : 내가 관심 있는 문서가 큐에서 몇 번째인지
     * - 셋째줄 : 테스트케이스 1 -> N개의 문서의 중요도(중요도가 같은 문서가 여러개 있을 수 있다)
     * - (반복)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine()); //테스트 케이스의 수

        for (int i = 0; i < total; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken()); //문서의 개수
            int M = Integer.parseInt(st.nextToken()); //현재 큐에서 몇번째인지

            st = new StringTokenizer(br.readLine(), " "); //문서의 중요도. 문서의 수만큼 주어진다
            //중요도를 담는 큐
            Queue<int[]> printList = new LinkedList<>();

            for (int j = 0; j < N; j++) {
                // 큐에 (중요도, 원래 위치) 형태로 추가
                // 큐에 저장되는 데이터 예시 : [1,0], [2,1], [3,2]...
                printList.offer(new int[]{Integer.parseInt(st.nextToken()), j});
            }

            // 출력 순서
            int order = 0;

            //문서 인쇄처리
            while (!printList.isEmpty()) {
                int[] current = printList.poll(); // 맨 앞에 있는 문서
                // current 안에는 [1,0] 처럼 (중요도, 원래위치)가 들어있다.
                boolean isMax = true;

                //나머지 문서들과 비교
                for (int[] doc : printList) {
                    if (doc[0] > current[0]) { //더 높은 중요도가 있다면
                        isMax = false;
                        break;
                    }
                }

                if (isMax) { //현재문서가 가장 중요하다면
                    order++; //인쇄 순서 증가
                    if (current[1] == M) { // current의 원래 위치가 내가 찾던 문서라면
                        bw.write(String.valueOf(order));
                        bw.newLine();
                        break;
                    }
                } else { //중요하지 않다면 다시 뒤로 보냄
                    printList.offer(current);
                }


            }


        }
        bw.flush();
        bw.close();

    }
}
