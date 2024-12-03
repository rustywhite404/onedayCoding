package hh99_3week.advance;

import java.io.*;
import java.util.*;

public class 보물1026 {
    /*
     * 입력 :
     * - 배열의 자릿수 N
     * - 배열 A의 값들 N개
     * - 배열 B의 값들 B개
     *
     * 연산 :
     * - S = A[0]*B[0]+A[1]*B[1]...
     * - 배열A1[N]을 만든다
     * - 우선순위 큐 A2를 만든다
     * - 배열B1[N]을 만든다
     * - 우선순위 큐(내림차순) B2를 만든다
     * - B1에서 B2에서 꺼내온 값을 찾아 자릿수를 반환한다
     * - A2에서 최소값을 꺼내서 A2의(B2에서 꺼내온 값의 자릿수)에 넣는다
     *
     * 출력 :
     * - S의 최소값 출력
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> A2 = new PriorityQueue<>();
        PriorityQueue<Integer> B2 = new PriorityQueue<>(Collections.reverseOrder());
        int[] A1 = new int[total];
        List<Integer> B1 = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < total; i++) {
            int num = Integer.parseInt(st.nextToken());
            A1[i] = num;
            A2.add(num);
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<total;i++){
            int num = Integer.parseInt(st.nextToken());
            B1.add(num);
            B2.add(num);
        }

        // 사용된 인덱스를 관리하기 위한 Set
        Set<Integer> usedIndexes = new HashSet<>();

        // B2에서 맨 위에 있는 값(최대값)을 꺼내서, B1의 어느 자리인지 찾기
        while (!B2.isEmpty()) {
            int findNum = B2.poll();

            // findNum이 처음 등장한 위치를 찾기
            int index = -1;
            for (int i = 0; i < B1.size(); i++) {
                if (B1.get(i) == findNum && !usedIndexes.contains(i)) {
                    index = i;
                    usedIndexes.add(i); // 인덱스를 사용했음을 표시
                    break;
                }
            }

            // A2에서 최소값을 꺼내서 해당 index에 값을 넣는다
            A1[index] = A2.poll();
        }

        //연산
        int sum = 0;
        for(int i=0;i<total;i++){
            sum += A1[i]*B1.get(i);
        }
        bw.write(sum+" ");
        bw.close();

    }

}
