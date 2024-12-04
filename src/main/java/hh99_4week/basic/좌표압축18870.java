package hh99_4week.basic;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 좌표압축18870 {
    /*
     * 좌표 압축이란 ? : 여러 좌표가 존재하는데 범위가 너무 커서 어려움이 생긴다면 진행 가능한 테크닉.
     * 원래 가지고 있던 값들의 의미는 사라지고, 순서에 따른 정보만 남게 된다.
     * 핵심 => 값들을 0부터 크기 순으로 정렬하고, 순위를 매긴다. 중복된 숫자는 같은 순위로 처리한다.
     * 이 순위들을 원래의 값에 매핑한다.
     *
     * 입력 :
     * - 첫줄에 N이 주어짐
     * - 둘째줄에는 N개의 좌표값이 공백으로 구분되어 주어짐
     *
     * 연산 :
     * - 배열에 원래 값을 하나 저장해둔다
     * - 좌표값을 중복 순위 없이 오름차순으로 정렬해야 하니 Treeset에 넣는다.
     * - HashMap에 <좌표값, 순위> 를 저장한다.
     * - 원래 값이 들어있던 배열에서, 해당 값(키)에 해당하는 순위를 찾아 매핑한다.
     * 출력 :
     * - 매핑한 배열의 값을 출력
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        int[] origin = new int[total];
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < total; i++) {
            int num = Integer.parseInt(st.nextToken());
            origin[i] = num; //배열에 원래 값 저장
            set.add(num); //좌표값을 treeset에 중복 없이 오름차순 정렬
        }

        Map<Integer,Integer> map = new HashMap<>();
        int setSize = set.size();
        for (int i=0;i<setSize;i++) {
            map.put(set.pollFirst(), i); //Map에 <좌표값, 순위> 저장
        }

        for(int i=0;i<origin.length;i++){
            if(map.containsKey(origin[i])){ //배열의 값이 map에 key로 존재한다면 values를 배열에 매핑
                origin[i] = map.get(origin[i]);
            }
        }

        for (int i : origin) {
            bw.write(i+" ");
        }
        bw.flush();
        bw.close();
    }
}
