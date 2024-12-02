package hh99_3week.basic;

import java.io.*;
import java.util.AbstractMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Yangjojang_of_The_Year11557 {
    /*
     * 입력 :
     * - 테스트 케이스의 숫자 T
     * - 테스트 케이스 시작 첫 줄 : 학교 숫자 정수 N
     * - 이후 N줄에 걸쳐 학교 이름과 해당 학교가 소비한 술의 양이 공백으로 구분된다.
     *
     * 연산 :
     * - 우선순위 큐를 Map형으로 받아서 풀면 될 것 같다
     *
     * - 출력 :
     * - 각 테스트 케이스마다 한 줄에 걸쳐 술 소비가 가장 많은 학교의 이름을 출력한다
     * */
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < caseCount; i++) {
            PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue()); //내림차순 정렬
            int uniCount = Integer.parseInt(br.readLine());
            for (int j = 0; j < uniCount; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                queue.add(new AbstractMap.SimpleEntry<>(st.nextToken(),Integer.parseInt(st.nextToken())));
            }
            bw.write(queue.peek().getKey());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
