package 이분탐색;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 선분위의점11663 {
    /*
     * 1 : 점의 개수 N, 선분의 개수 M
     * 2 : 점의 좌표(일차원 좌표 상)
     * 3 ~ M : 선분의 시작점, 끝점
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] point = new long[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            point[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(point);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int startIdx = binarySearch(point, start, 0); //시작지점 이상 갯수
            int endIdx = binarySearch(point, end, 1); //끝지점 이하 갯수
            bw.write(endIdx - startIdx + " ");
            bw.newLine();

        }
        bw.flush();
        bw.close();

    }

    private static int binarySearch(long[] point, int target, int type) {
        int left = 0;
        int right = point.length - 1;
        if (type == 0) {
            while (left <= right) {
                int mid = (left + right) / 2;
                if (point[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        } else {
            while (left <= right) {
                int mid = (left + right) / 2;
                if (point[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return right + 1;
        }
    }

}
