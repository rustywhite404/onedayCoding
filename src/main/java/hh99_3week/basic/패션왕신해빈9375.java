package hh99_3week.basic;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 패션왕신해빈9375 {
    /*
     * 입력 :
     * - 첫줄에 테스트 케이스의 수 T
     * - 둘째줄부터 테스트 케이스 시작. 테스트 케이스의 첫줄에는 의상의 수 N이 주어짐
     * - 다음 N개에는 의상의 이름과 종류가 공백으로 구분되어 주어진다.
     *
     * 연산 :
     * - 각각의 의상은 '입지 않는다'를 포함해서 의상 수 N+1 개의 선택지가 있다.
     * - 모자 수 (N+1) * 상의 수(M+1) * 하의 수(O+1)... -1(모두 안입은 경우) : 를 출력한다.
     *
     * 출력 :
     * 각 테스트 케이스에 대해 알몸이 아니면서 중복되지 않고 입을 수 있는 경우의 수를 구하시오.
     *
     * */
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalCount = Integer.parseInt(br.readLine()); //테스트의 수
        for (int i = 0; i < totalCount; i++) {
            int clothesAmount = Integer.parseInt(br.readLine()); //의상의 수
            HashMap<String, Integer> itemCount = new HashMap<>();
            for (int j = 0; j < clothesAmount; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String clothesName = st.nextToken();
                String category = st.nextToken();
                if (itemCount.containsKey(category)) { //이미 이 카테고리가 존재한다면 value를 증가
                    itemCount.put(category,itemCount.get(category)+1);
                } else {
                    itemCount.put(category, 1); //신규 카테고리라면 1로 등록
                }
            }
            int result = 1;
            //해시테이블에 등록이 끝나면 각 카테고리별 아이템의 수+1한 값을 모두 곱하고 1을 뺀다
            for (Map.Entry<String, Integer> entry : itemCount.entrySet()) {
                result *= entry.getValue()+1;
            }
            bw.write((result-1)+" ");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
