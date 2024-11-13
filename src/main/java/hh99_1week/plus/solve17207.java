package hh99_1week.plus;

import java.io.*;
import java.util.*;

public class solve17207 {
    public static void main(String[] args) throws IOException {
        /*
        1. 문제 분석
        - 일은 5개
        - 번호 : 인서 1 / 준석 2 / 정우 3 / 진우 4 / 영기 5
        - 행렬 A : int[5][5]. x행 y열의 값 = x번 사람이 예상한 y번째 일의 난이도
        - 행렬 B : int[5][5]. x행 y열의 값 = x번 사람이 예상한 y번째 일의 처리시간
        - x번 사람의 y번째 일 예상 일량 : A[x][i] * B[i][y] (i = 1->5)
        - 각자의 최종 일량 : 1번 일부터 5번 일까지 이 사람의 예상 일량을 모두 합친 값
        - 제일 덜 바쁜 사람 : 최종 일량이 제일 적은 사람
        - 단, 제일 덜 바쁜 사람이 2명 이상이면 번호가 빠른 사람을 출력
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[][] A = new int[5][5]; //난이도
        int[][] B = new int[5][5]; //처리시간
        String[] nameList = new String[]{"Inseo", "Junsuk", "Jungwoo", "Jinwoo", "Youngki"}; //행렬의 이름 순서
        String[] priorityOrder = new String[]{"Youngki", "Jinwoo", "Jungwoo", "Junsuk", "Inseo"};  // 중복 최소값이 존재할 때 비교할 순서
        int[] findMin = new int[5]; //최종 일량
        Map<String, Integer> list = new HashMap<>(); //이름-최종 일량 저장

        //행렬 A 초기화
        for(int i=0;i<5;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<5;j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //행렬 B 초기화
        for(int i=0;i<5;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<5;j++){
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // 예상 일량 계산
        for (int x = 0; x < 5; x++) {
            int sum = 0; // 각 사람별 일량을 계산하기 위해 sum을 여기에 초기화
            for (int y = 0; y < 5; y++) {
                for (int i = 0; i < 5; i++) {
                    sum += A[x][i] * B[i][y]; // x번 사람이 i번째 일의 난이도 × i번 사람이 y번째 일의 처리 시간
                }
            }
            findMin[x] = sum; // 각 사람의 최종 일량을 findMin 배열에 저장
            //각자의 이름 - 최종 일량을 저장
            list.put(nameList[x],findMin[x]);
        }


        // 1. 최소값 찾기
        int minValue = Collections.min(list.values());

        // 2. 최소값을 가진 키들 찾기
        List<String> minKeys = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : list.entrySet()) {
            if (entry.getValue() == minValue) {
                minKeys.add(entry.getKey());
            }
        }

        // 3. priorityOrder 순서대로 최소값을 가진 키 중 가장 앞선 것을 반환
        for (String name : priorityOrder) {
            if (minKeys.contains(name)) {
                bw.write(name);
                break;
            }
        }


        bw.flush();
        bw.close();
    }
}
