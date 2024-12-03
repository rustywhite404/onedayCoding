package hh99_3week.advance;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파일합치기13795 {
    /*
     * 입력 :
     * - 첫줄에 테스트 케이수 개수 T
     * - 테스트 케이스 첫줄 : 소설의 챕터 수 K
     * - 둘째줄 : 각 챕터의 파일 크기
     *
     * 연산 :
     * - 첫번째 리스트에서 주어진 값들끼리 짝을 지어 합치고,
     * - 새로 생긴 리스트에서 주어진 값들을 다시 합친다
     * - 리스트의 길이가 1이 될 때까지 반복
     * - 합치면서 누적된 값들은 따로 기록한다
     * - 맨 앞에 있는 값 두개를 합쳐서 다시 넣었을 때 맨 뒤로 가야하므로 데크로 생성
     * - => 최소값으로 오름차순 한 값 두개를 합쳤을 때가 정렬하지 않았을 때보다 최소값이 적게 나옴. 우선순위 큐로 변경
     * 출력 : 파일들을 전부 하나로 합쳤을 때 필요한 최소 비용을 계산
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            PriorityQueue<Long> chapterList = new PriorityQueue<>();
            long totalPageCount = 0;
            int chapter = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < chapter; j++) {
                chapterList.add(Long.parseLong(st.nextToken())); //큐에 초기값들 모두 입력
            }
            while (chapterList.size()!=1){ //큐 사이즈가 1이 되면 반복 종료
                //큐에서 맨 앞 두개의 값을 꺼내서 합치고 맨 뒤로 보냄
                long temp = chapterList.poll()+chapterList.poll();
                chapterList.add(temp);
                totalPageCount += temp;
            }
            bw.write(totalPageCount+" ");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
