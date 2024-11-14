package hh99_1week;

import java.io.*;
import java.util.Arrays;

public class tip {
    //알고리즘 공부를 하며 유용하게 사용한 메서드들
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. Arrays.fill
        // 배열을 같은 값으로 한번에 채울 때 유용하다(1차원 배열에서만 가능)
        int [] arr1 = new int[5];
        Arrays.fill(arr1, 0);

        for (int ints : arr1) {
            bw.write(String.valueOf(ints));
        }
        bw.flush();
        bw.close();

    }
}
