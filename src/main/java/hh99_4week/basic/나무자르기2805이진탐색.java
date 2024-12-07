package hh99_4week.basic;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 입력 :
 * - 나무의 수 N, 집으로 가져가고 싶은 길이 M
 * - 각 나무들의 높이 N개
 *
 * 연산 :
 * - 설정한 높이 H 이상의 높이들이 다 잘림
 * - 높이를 제일 높은 나무 높이-1부터 시작함.
 * - 각 나무에서 자른 수들을 다 더했을 때 M과 같거나 커야함.
 * => 이분 탐색을 사용해서 자를 높이 H를 빠르게 찾아야 한다.
 * - 최소 높이0, 최대 높이를 설정한다
 * - 중간값을 기준으로 필요한 나무 길이를 계산한다
 * - 목표치보다 크면 더 높은 높이를 시도하고, 목표치보다 작으면 더 낮은 높이를 시도해본다.
 *
 * 출력 :
 * - 최소 M미터의 나무를 가져가려면 절단기에 설정해야 하는 값 H 출력
 * */
public class 나무자르기2805이진탐색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int treeAmount = Integer.parseInt(st.nextToken());
        long hopeAmount = Long.parseLong(st.nextToken());
        long currentAmount = 0;
        int[] treeList = new int[treeAmount];
        st = new StringTokenizer(br.readLine());

        //나무 세팅
        for (int i = 0; i < treeAmount; i++) {
            treeList[i] = Integer.parseInt(st.nextToken());
        }

        //나무 크기순 정렬
        Arrays.sort(treeList);

        //이분 탐색을 위한 범위 설정
        long low = 0; //최소높이
        long high = treeList[treeAmount - 1]; //최대높이
        long result = 0; //결과값 저장

        while (low <= high) { //둘이 교차하기 전까지 이분탐색
            long mid = (low + high) / 2;
            long total = 0;

            //현재 높이(mid)로 잘랐을 때 얻을 수 있는 나무 길이 계산
            for (int height : treeList) {
                if (height > mid) {
                    total += height - mid;
                }
            }
            // 목표길이 충족 여부에 따라 범위 조정
            if (total >= hopeAmount) {
                //희망높이보다 많이 잘랐을 경우
                result = mid; //우선 답 후보로 올려둠
                low = mid + 1; //더 높은 곳을 잘라보도록 눈금(mid) 올리기

            } else { //희망높이가 아직 더 많을 경우
                high = mid - 1; //더 낮은 곳을 자르도록 눈금(mid) 낮추기

            }

        }


        bw.write(result + " ");
        bw.flush();
        bw.close();
    }
}
