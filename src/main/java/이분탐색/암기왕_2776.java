package 이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암기왕_2776 {
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int total = Integer.parseInt(br.readLine());
        for (int i = 0; i < total; i++) {
            int note1Count = Integer.parseInt(br.readLine());
            int[] note1 = new int[note1Count];
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < note1Count; j++) {
                note1[j] = Integer.parseInt(st.nextToken());
            }

            //note1 정렬
            Arrays.sort(note1);

            int note2Count = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < note2Count; j++) {
                int currentNum = Integer.parseInt(st.nextToken());
                if (binarySearch(note1, currentNum)) {
                    bw.write("1");
                } else {
                    bw.write("0");
                }
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }

    private static boolean binarySearch(int[] arr, int currentNum) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;
            if (arr[mid] == currentNum) {
                return true;
            } else if (arr[mid] < currentNum) {
                left = mid + 1; //오른쪽 절반
            } else {
                right = mid - 1; //왼쪽 절반
            }
        }

        return false;
    }
}
