package hh99_3week.advance;

import java.util.*;

public class 센티와마법의뿅망치_배열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 거인의 수
        int h = sc.nextInt(); // 목표 키
        int t = sc.nextInt(); // 뿅망치 횟수

        int[] giants = new int[n];
        for (int i = 0; i < n; i++) {
            giants[i] = sc.nextInt();
        }

        // 뿅망치 사용
        for (int i = 0; i < t; i++) {
            // 현재 최댓값 찾기
            int maxIndex = 0;
            for (int j = 1; j < n; j++) {
                if (giants[j] > giants[maxIndex]) {
                    maxIndex = j;
                }
            }

            // 가장 큰 거인의 키가 목표 이하라면 종료
            if (giants[maxIndex] < h) {
                System.out.println("YES");
                System.out.println(i);
                return;
            }

            // 뿅망치 사용
            if (giants[maxIndex] > 1) {
                giants[maxIndex] /= 2; // 키를 반으로 줄임
            }
        }

        // 모든 뿅망치 사용 후 검사
        int max = Arrays.stream(giants).max().getAsInt();
        if (max < h) {
            System.out.println("YES");
            System.out.println(t);
        } else {
            System.out.println("NO");
            System.out.println(max);
        }
    }
}