package 이분탐색;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 랜선자르기1654 {
    /*
     * 1 : 가지고 있는 랜선의 수 K, 필요한 랜선의 수 N
     * 2~K : K줄에 걸쳐 이미 가지고 있는 랜선의 길이가 센티미터 단위 정수로 입력된다
     * - 우선 랜선을 오름차순으로 정렬한다
     * - 정렬한 랜선을 이분탐색한다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int total = Integer.parseInt(st.nextToken());
        int need = Integer.parseInt(st.nextToken());
        int[] arr = new int[total];
        for (int i = 0; i < total; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        bw.write(binarySearch(arr, need, total)+" ");
        bw.flush();
        bw.close();
    }

    private static Long binarySearch(int[] arr, int need, int total) {

        long start = 1;
        long last = arr[arr.length - 1];
        long result = 0;


        while (start <= last) {
            long mid = (start + last) / 2;
            long count = 0;

            for (int length : arr) {
                count += length / mid; //현재 mid 길이로 만들 수 있는 랜선 개수 계산
            }

            if (count >= need) {
                result = mid;
                start = mid + 1; //더 긴 랜선을 찾기
            }else {
                last = mid - 1; //범위를 왼쪽으로 이동
            }

        }

        return result;
    }
}
