package hh99_1week.basic;

import java.io.*;
import java.util.*;

public class solve17207refactoring {
    public static void main(String[] args) throws IOException {
        /*
        문제 분석
        - 일은 5개
        - 번호 : 인서 1 / 준석 2 / 정우 3 / 진우 4 / 영기 5
        - 행렬 A : int[5][5]. x행 y열의 값 = x번 사람이 예상한 y번째 일의 난이도
        - 행렬 B : int[5][5]. x행 y열의 값 = x번 사람이 예상한 y번째 일의 처리시간
        - x번 사람의 y번째 일 예상 일량 : A[x][i] * B[i][y] (i = 1->5)
        - 각자의 최종 일량 : 1번 일부터 5번 일까지 이 사람의 예상 일량을 모두 합친 값
        - 제일 덜 바쁜 사람 : 최종 일량이 제일 적은 사람
        - 단, 제일 덜 바쁜 사람이 2명 이상이면 번호가 빠른 사람을 출력

        풀이 전략
        - 일단 각자의 최종 일량을 구한다
        - x, y열에 따른 모두의 최종 일량을 구한다
        - 제일 일량이 적은 사람의 이름을 구한다
        - 단독이면 그대로 출력하고, 동률이 있을 경우 정해진 이름 순서 중 먼저 호출되는 사람을 출력한다.
         */

        // 1. 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[][] A = new int[5][5]; //난이도
        int[][] B = new int[5][5]; //처리시간
        String[] nameList = new String[]{"Inseo", "Junsuk", "Jungwoo", "Jinwoo", "Youngki"}; //행렬의 이름 순서
        String[] priorityOrder = new String[]{"Youngki", "Jinwoo", "Jungwoo", "Junsuk", "Inseo"};  // 중복 최소값이 존재할 때 비교할 순서
        Map<String,Integer> list = new HashMap<>(); // 사람-일량 매핑용 리스트

        // 2. 행렬 A, B 초기화
        for(int i=0;i<5;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<5;j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<5;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<5;j++){
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 3. 예상 일량 계산
        for(int x=0;x<5;x++){
            int sum = 0;
            for(int y=0;y<5;y++){
                for(int i=0;i<5;i++){
                    sum += A[x][i]*B[i][y];
                }
            }
            list.put(nameList[x],sum); //각자의 최종 예상 일량
        }

        // 4. 예상 일량 중 최소값 찾기
        int minValue = Collections.min(list.values());

        // 5. 최소값을 가진 키(복수일 수 있음) 찾기
        List<String> minKeys = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : list.entrySet()) {
            if(entry.getValue()==minValue){
                minKeys.add(entry.getKey());
            }
        }

        // 6. 최소값을 가진 키를 priorityOrder 순서대로 비교해서 맨 앞의 값을 반환
        for(String name : priorityOrder){
            if(minKeys.contains(name)){
                bw.write(name);
                break;
            }
        }

        bw.flush();
        bw.close();
    }
}
