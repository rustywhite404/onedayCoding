package hh99_1week.basic;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class solve27160 {
    /*
    문제 분석 :
    - 첫줄에 카드의 개수 n이 주어진다
    - 2~n줄에는 카드의 종류 문자열S, 과일의 숫자 x가 주어진다.
    - 같은 종류의 과일이 정확히 5개 있을 때 YES를 반환한다
    - 같은 종류의 과일이 정확히 5개가 아니라면 NO를 반환한다

     풀이 전략 :
     - 윗줄부터 HashMap에 카드 종류, 숫자를 저장한다
     - 이미 해당 카드 종류가 저장되어 있다면 숫자를 더한다
     - 합산이 끝난 후, 값이 5인 카드가 있다면 YES, 아니면 NO를 리턴한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int total = Integer.parseInt(br.readLine());
        Map<String, Integer> haligali = new HashMap<>();
        for (int i = 0; i < total; i++) {
            st = new StringTokenizer(br.readLine()," ");
            String key = st.nextToken();
            int count = Integer.parseInt(st.nextToken());

            if(haligali.containsKey(key)){ // 해당 카드가 이미 저장되어 있다면
                haligali.put(key,haligali.get(key)+count);
            }else{
                haligali.put(key,count);
            }
        }
        // 반복 종료 후 value가 5인 값이 있는지 확인
        if(haligali.containsValue(5)){
            bw.write("YES");
        }else {
            bw.write("NO");
        }
        bw.flush();
        bw.close();
    }
}
