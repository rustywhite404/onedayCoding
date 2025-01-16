package 이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 기타레슨2343 {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int maxLesson = 0; //제일 긴 강의
        int sumLesson = 0; //모든 강의의 합
        int[] lesson = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            lesson[i] = Integer.parseInt(st.nextToken());
            maxLesson = Math.max(maxLesson, lesson[i]); //제일 긴 강의 갱신
            sumLesson += lesson[i]; //강의의 합 갱신
        }
        int left = maxLesson; //최소 블루레이 크기 : 제일 긴 강의 1개
        int right = sumLesson; //최대 블루레기 크기 : 전체의 합
        int answer = right;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (binarySearch(lesson, mid) <= m) { //이분탐색 결과가 M개 이하라면
                answer = mid; //현재의 최소값 저장
                right = mid - 1; //더 작은 크기로도 가능한지 탐색
            } else {
                left = mid + 1; //블루레이 크기를 늘려야 함
            }
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    private static int binarySearch(int[] lesson, int mid) {
        //주어진 블루레이 크기로 강의를 몇 개의 블루레이로 나눌 수 있는지 계산
        int count = 1; //최소 1개
        int total = 0; //현재 블루레이에 담긴 강의 총 길이

        for (int i : lesson) {
            if (total + i > mid) { //현재 블루레이에 담을 수 없으면
                count++;
                total = i;
            }else{
                total += i;
            }
        }

        return count;
    }
}
